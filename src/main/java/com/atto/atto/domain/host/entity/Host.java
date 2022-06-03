package com.atto.atto.domain.host.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Builder
@Entity
@Table(name = "t_host")
@NoArgsConstructor
@AllArgsConstructor
public class Host {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "host",nullable = false,unique = true)
    private String name;

    @Column(name = "ip",nullable = false,unique = true)
    private String ip;

    private LocalDateTime lastAliveDate;

    private LocalDateTime createdDate;

    private LocalDateTime modifiedDate;




}
