package com.atto.atto.global.error.exception;

import com.atto.atto.global.error.model.ErrorCode;

public class BusinessException extends RuntimeException{
    private ErrorCode errorCode;
    public BusinessException(ErrorCode errorCode){

        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
    public ErrorCode getErrorCode(){

        return errorCode;

    }

}
