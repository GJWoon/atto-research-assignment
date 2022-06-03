package com.atto.atto.domain.host.entity;


import com.atto.atto.domain.host.dto.request.HostNameAndIpDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Builder
@Entity
@Table(name = "t_host")
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Host {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "host", nullable = false, unique = true)
    private String name;

    @Column(name = "ip", nullable = false, unique = true)
    private String ip;

    private LocalDateTime lastAliveDate;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;

    public static Host create(HostNameAndIpDto dto) {
        return Host.builder()
                .ip(dto.getIp())
                .name(dto.getName())
                .build();
    }
    public void update(HostNameAndIpDto dto){
        this.ip = dto.getIp();
        this.name = dto.getName();
    }

}
