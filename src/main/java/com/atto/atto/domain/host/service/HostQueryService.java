package com.atto.atto.domain.host.service;


import com.atto.atto.domain.host.dto.response.HostDtoAndLastAliveTime;
import com.atto.atto.domain.host.entity.Host;
import com.atto.atto.domain.host.repository.HostRepository;
import com.atto.atto.domain.host.repository.HostRepositorySupport;
import com.atto.atto.global.error.exception.BusinessException;
import com.atto.atto.global.error.model.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class HostQueryService {

    private final HostRepositorySupport hostRepositorySupport;
    private final HostRepository hostRepository;
    private final JdbcTemplate jdbcTemplate;

    public List<HostDtoAndLastAliveTime> findHostAliveAll(){

        List<Host> hostList = hostRepository.findAll();

        List<HostDtoAndLastAliveTime> dtoList = new ArrayList<>();

        hostList.forEach(host ->{
            dtoList.add(checkAlive(host));
        });
        batchUpdateAliveDate(dtoList.stream().filter(HostDtoAndLastAliveTime::isAlive).collect(Collectors.toList())
        );
        return dtoList;
    }

    @Transactional
    public HostDtoAndLastAliveTime findHostAliveById(Long id){
        Host host = findById(id);
        HostDtoAndLastAliveTime dto = checkAlive(host);
        if(dto.isAlive()){
            host.updateLastAliveDate();
        }
         return dto;
    }

    public Host findById(Long id) {
        return hostRepositorySupport.findById(id);
    }

    public HostDtoAndLastAliveTime checkAlive(Host host){

        HostDtoAndLastAliveTime hostDtoAndLastAliveTime = new HostDtoAndLastAliveTime(host);
        InetAddress pingCheck = null;
        try {
            pingCheck = InetAddress.getByName(host.getIp());
        } catch (UnknownHostException e) {
            log.error("호스트의 IP 주소 {} 를 확인할 수 없음",host.getIp());
            e.printStackTrace();
            return hostDtoAndLastAliveTime;
        }

        try {
            if(pingCheck.isReachable(1000)){
                hostDtoAndLastAliveTime.setAlive(true);
                hostDtoAndLastAliveTime.setLastAliveDate();
                }
        } catch (IOException e) {
            log.error("Ping Test 도중 에러 발생 ip: {}",host.getIp());
            e.printStackTrace();
        }
        return hostDtoAndLastAliveTime;
    }

    public void batchUpdateAliveDate(List<HostDtoAndLastAliveTime> dtoList) {
        String sql = "UPDATE t_host SET lastAliveDate = ? WHERE id = ?";
        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                HostDtoAndLastAliveTime dto = dtoList.get(i);
                ps.setTimestamp(1, Timestamp.valueOf(dto.getLastAliveDate()));
                ps.setLong(2, dto.getId());
            }
            @Override
            public int getBatchSize() {
                return dtoList.size();
            }
        });
    }
}
