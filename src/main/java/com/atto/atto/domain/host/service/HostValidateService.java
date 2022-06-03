package com.atto.atto.domain.host.service;

import com.atto.atto.domain.host.dto.request.HostNameAndIpDto;
import com.atto.atto.domain.host.repository.HostRepositorySupport;
import com.atto.atto.global.error.exception.BusinessException;
import com.atto.atto.global.error.model.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HostValidateService {

    private final HostRepositorySupport hostRepositorySupport;

    public void duplicateCheck(HostNameAndIpDto dto){
        duplicateCheckName(dto.getName());
        duplicateCheckIp(dto.getIp());
    }

    public void checkCount() {
        long count = hostRepositorySupport.checkCount();
        if (count == 100) {
            throw new BusinessException(ErrorCode.MORE_THAN_100);
        }
    }

    public void duplicateCheckName(String name) {
        long count = hostRepositorySupport.countByName(name);
        if (count != 0) {
            throw new BusinessException(ErrorCode.DUPLICATE_NAME);
        }
    }
    public void duplicateCheckIp(String ip) {
        long count = hostRepositorySupport.countByIp(ip);
        if (count != 0) {
            throw new BusinessException(ErrorCode.DUPLICATE_IP);
        }
    }

}
