package com.atto.atto.domain.host.dto.response;

import com.atto.atto.domain.host.dto.request.HostNameAndIpDto;
import com.atto.atto.domain.host.entity.Host;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class HostDto extends HostNameAndIpDto {

    private Long id;

    private String createdDate;

    private String modifiedDate;

    public HostDto(Host host){
        super(host.getName(),host.getIp());
        this.id = host.getId();
        this.createdDate = String.valueOf(host.getCreatedDate());
        this.modifiedDate = String.valueOf(host.getModifiedDate());
    }
}
