package com.atto.atto.domain.host.api;


import com.atto.atto.domain.host.dto.request.HostNameAndIpDto;
import com.atto.atto.domain.host.service.HostCreateService;
import com.atto.atto.domain.host.service.HostValidateService;
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
    @PostMapping
    public ApiResponse<String> createHost(@RequestBody @Validated HostNameAndIpDto dto){
        hostValidateService.checkCount();
        hostValidateService.duplicateCheck(dto);
        return new ApiResponse<>(hostCreateService.create(dto));
    }

//    @PutMapping("/{id}")
//    public ApiResponse<String> updateHost(@RequestBody @Validated HostNameAndIpDto dto,
//                                          @PathVariable Long id
//                                          ){
//        return new ApiResponse<>(hostCreateService.update(dto,id));
//    }
//

}
