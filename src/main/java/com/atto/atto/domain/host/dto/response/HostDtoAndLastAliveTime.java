package com.atto.atto.domain.host.dto.response;


import com.atto.atto.domain.host.entity.Host;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class HostDtoAndLastAliveTime extends HostDto{

    private LocalDateTime lastAliveDate;
    private boolean alive;
    public HostDtoAndLastAliveTime(Host host){
        super(host);
        this.lastAliveDate = host.getLastAliveDate();
        this.alive = false;
    }

    public void setAlive(boolean alive){
        this.alive = alive;
    }

    public void setLastAliveDate(){
        this.lastAliveDate = LocalDateTime.now();
    }
}
