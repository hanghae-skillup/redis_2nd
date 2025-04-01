package com.pepponechoi.cinema.exception.exception;

import com.pepponechoi.cinema.exception.enums.BadRequestErrorCode;
import lombok.Getter;

@Getter
public class BadRequestException extends RuntimeException implements CustomException<BadRequestErrorCode>{

    private BadRequestErrorCode errorCode;
    private Object detail;

    public BadRequestException() {
        this.errorCode = BadRequestErrorCode.BAD_REQUEST;
    }

    @Override
    public void setErrorCode(BadRequestErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public void setDetail(Object detail) {
        this.detail = detail;
    }
}
