package com.atto.atto.domain.host.service;


import com.atto.atto.domain.host.entity.Host;
import com.atto.atto.domain.host.repository.HostRepositorySupport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HostQueryService {

    private final HostRepositorySupport hostRepositorySupport;

    public Host findById(Long id) {
        return hostRepositorySupport.findById(id);
    }


}
