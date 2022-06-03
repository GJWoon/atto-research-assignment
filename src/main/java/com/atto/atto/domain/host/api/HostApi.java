package com.atto.atto.domain.host.api;


import com.atto.atto.domain.host.dto.request.HostNameAndIpDto;
import com.atto.atto.domain.host.entity.Host;
import com.atto.atto.domain.host.service.*;
import com.atto.atto.global.error.dto.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    public ApiResponse<Boolean> createHost(@RequestBody @Validated HostNameAndIpDto dto) {
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

}
