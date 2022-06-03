package com.atto.atto.domain.host.service;

import com.atto.atto.domain.host.dto.request.HostNameAndIpDto;
import com.atto.atto.domain.host.entity.Host;
import com.atto.atto.domain.host.repository.HostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class HostUpdateService {

    @Transactional
    public boolean update(Host host, HostNameAndIpDto dto) {
        host.update(dto);
        return true;
    }
}
