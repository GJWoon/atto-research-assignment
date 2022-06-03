package com.atto.atto.domain.host.service;


import com.atto.atto.domain.host.dto.response.HostDtoAndLastAliveTime;
import com.atto.atto.domain.host.entity.Host;
import com.atto.atto.domain.host.repository.HostRepository;
import com.atto.atto.domain.host.repository.HostRepositorySupport;
import com.atto.atto.global.error.exception.BusinessException;
import com.atto.atto.global.error.model.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class HostQueryService {

    private final HostRepositorySupport hostRepositorySupport;
    private final HostRepository hostRepository;

    @Transactional
    public List<HostDtoAndLastAliveTime> findHostAliveAll(){
        List<Host> hostList = hostRepository.findAll();
        hostList.forEach(this::checkAlive);
       return hostList
               .stream()
               .map(host ->
                       new HostDtoAndLastAliveTime(host,checkAlive(host)
                       )
               ).collect(Collectors.toList());
    }


    @Transactional
    public HostDtoAndLastAliveTime findHostAliveById(Long id){
        Host host = findById(id);
        return new HostDtoAndLastAliveTime(host,checkAlive(host));
    }

    public Host findById(Long id) {
        return hostRepositorySupport.findById(id);
    }


    public boolean checkAlive(Host host){

        boolean resultPingCheck = false;

        InetAddress pingCheck = null;
        try {
            pingCheck = InetAddress.getByName(host.getIp());
        } catch (UnknownHostException e) {
            log.info("호스트의 IP 주소를 확인할 수 없음");
            e.printStackTrace();
            return false;
        }

        try {
            if(pingCheck.isReachable(1)){
                resultPingCheck = true;
                host.updateLastAliveDate();
            }
        } catch (IOException e) {
            log.info("Ping Test 도중 에러 발생");
            e.printStackTrace();
        }
        return resultPingCheck;
    }
}
