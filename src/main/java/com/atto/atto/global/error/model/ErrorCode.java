package com.atto.atto.global.error.model;

public enum ErrorCode {

    INTERNAL_SERVER_ERROR(500, "A000", "알 수 없는 에러 (서버 에러)"),
    DUPLICATE_IP(509, "A001", "중복된 IP입니다.."),
    DUPLICATE_NAME(509, "A002", "중복된 호스트명 입니다."),
    MORE_THAN_100(509, "A003", "호스트는 100갸까지 등록 가능합니다."),
    NOT_FOUND_HOST(404, "A004", "존재하지 않는 호스트입니다."),
    NOT_FOUND_HOST_IP(404, "A005", "호스트의 IP 주소를 확인할 수 없습니다."),
    PING_TEST_ERROR(509, "A005", "Ping Test 도중 오류가 발생했습니다.");
            ;


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
