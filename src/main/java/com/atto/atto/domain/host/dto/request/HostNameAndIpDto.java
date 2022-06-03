package com.atto.atto.domain.host.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HostNameAndIpDto {

    @NotNull
    private String name;
    @NotNull
    private String ip;
}
