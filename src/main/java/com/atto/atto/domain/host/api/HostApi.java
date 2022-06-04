package com.atto.atto.domain.host.api;


import com.atto.atto.domain.host.dto.request.HostNameAndIpDto;
import com.atto.atto.domain.host.dto.response.HostDto;
import com.atto.atto.domain.host.dto.response.HostDtoAndLastAliveTime;
import com.atto.atto.domain.host.entity.Host;
import com.atto.atto.domain.host.service.*;
import com.atto.atto.global.error.dto.ApiListResponse;
import com.atto.atto.global.error.dto.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/host")
public class HostApi {

    private final HostCreateService hostCreateService;
    private final HostValidateService hostValidateService;
    private final HostQueryService hostQueryService;
    private final HostUpdateService hostUpdateService;
    private final HostDeleteService hostDeleteService;

    @PostMapping
    public ApiResponse<Boolean> createHost(@RequestBody @Valid HostNameAndIpDto dto) {
        hostValidateService.checkCount();
        hostValidateService.duplicateCheck(dto);
        return new ApiResponse<>(hostCreateService.create(dto));
    }
    @PutMapping("/{id}")
    public ApiResponse<Boolean> updateHost(@RequestBody @Validated HostNameAndIpDto dto,
                                          @PathVariable Long id
    ) {
        Host host = hostQueryService.findById(id);
        hostValidateService.duplicateCheck(dto);
        return new ApiResponse<>(hostUpdateService.update(host, dto));
    }
    @DeleteMapping("/{id}")
    public ApiResponse<Boolean> deleteHost(@PathVariable Long id){
        Host host = hostQueryService.findById(id);
        return new ApiResponse<>(hostDeleteService.deleteHost(host));
    }
    @GetMapping("/{id}")
    public ApiResponse<HostDto> findHostById(@PathVariable Long id){
        return new ApiResponse<>(new HostDto(hostQueryService.findById(id)));
    }

    @GetMapping("/alive/{id}")
    public ApiResponse<HostDtoAndLastAliveTime> findHostAliveById(@PathVariable Long id){
        return new ApiResponse<>(hostQueryService.findHostAliveById(id));
    }

    @GetMapping("/alive")
    public ApiListResponse<HostDtoAndLastAliveTime> findHostAliveAll(){
        return new ApiListResponse<>(hostQueryService.findHostAliveAll());
    }

}

