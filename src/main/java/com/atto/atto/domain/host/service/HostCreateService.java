package com.atto.atto.domain.host.service;

import com.atto.atto.domain.host.dto.request.HostNameAndIpDto;
import com.atto.atto.domain.host.entity.Host;
import com.atto.atto.domain.host.repository.HostRepository;
import com.atto.atto.domain.host.repository.HostRepositorySupport;
import com.atto.atto.global.error.exception.BusinessException;
import com.atto.atto.global.error.model.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HostCreateService {

    private final HostRepository hostRepository;

    public String create(HostNameAndIpDto dto) {

        Host host = Host.create(dto);

        hostRepository.save(host);

        return "Y";
    }


}
