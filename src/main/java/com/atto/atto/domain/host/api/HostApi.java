package com.atto.atto.domain.host.api;


import com.atto.atto.domain.host.dto.request.HostNameAndIpDto;
import com.atto.atto.domain.host.service.HostCreateService;
import com.atto.atto.global.error.dto.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/host")
public class HostApi {

    private final HostCreateService hostCreateService;

    @PostMapping
    public ApiResponse<String> createHost(@RequestBody @Validated HostNameAndIpDto dto){
        return new ApiResponse<>(hostCreateService.create(dto));
    }



}
