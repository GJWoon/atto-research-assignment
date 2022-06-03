package com.atto.atto.global.error.model;

public enum ErrorCode {

    INTERNAL_SERVER_ERROR(500, "A000", "알 수 없는 에러 (서버 에러)"),
    INVALID_TYPE_VALUE(400, "C001", "타입이 올바르지 않습니다.");


    private final int status;
    private final String code;
    private final String message;

   ErrorCode(final int status, final String code, final String message) {
        this.status = status;
        this.message = message;
        this.code = code;
    }
    public String getMessage() {
        return this.message;
    }

    public String getCode() {
        return code;
    }

    public int getStatus() {
        return status;
    }

}
