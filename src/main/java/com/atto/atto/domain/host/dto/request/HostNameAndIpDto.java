package com.atto.atto.domain.host.dto.request;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class HostNameAndIpDto {
    private String name;

    private String ip;
}
