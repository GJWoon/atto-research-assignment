package com.atto.atto;

import com.atto.atto.global.error.exception.BusinessException;
import com.atto.atto.global.error.model.ErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ErrorTest {


    @Test
    @DisplayName("error return test")
    void errorTest(){
        throw new BusinessException(ErrorCode.INTERNAL_SERVER_ERROR);
    }

}
