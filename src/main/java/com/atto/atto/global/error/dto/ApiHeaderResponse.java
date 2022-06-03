package com.atto.atto.global.error.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApiHeaderResponse {
    private final String result_code;
    private final String result_message;

    public ApiHeaderResponse() {
        this.result_code = "200";
        this.result_message = "요청요청이 정상적으로 처리되었습니다.";
    }



}
