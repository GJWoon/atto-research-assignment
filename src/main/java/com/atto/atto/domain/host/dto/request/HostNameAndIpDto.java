package com.atto.atto.domain.host.dto.request;


import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
public class HostNameAndIpDto {

    @NotNull
    private String name;
    @NotNull
    private String ip;
}
