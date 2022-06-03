package com.atto.atto.domain.host.dto.response;


import com.atto.atto.domain.host.entity.Host;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class HostDtoAndLastAliveTime extends HostDto{

    private String lastAliveDate;
    private boolean alive;
    public HostDtoAndLastAliveTime(Host host,boolean alive){
        super(host);
        this.lastAliveDate = String.valueOf(host.getLastAliveDate());
        this.alive = alive;

    }
}
