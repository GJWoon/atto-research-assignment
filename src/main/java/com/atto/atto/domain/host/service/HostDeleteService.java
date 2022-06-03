package com.atto.atto.domain.host.service;


import com.atto.atto.domain.host.entity.Host;
import com.atto.atto.domain.host.repository.HostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HostDeleteService {

    private final HostRepository hostRepository;

    public boolean deleteHost(Host host){

        hostRepository.delete(host);
        return true;
    }
}
