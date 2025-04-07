package com.pepponechoi.cinema.exception.exception;

import com.pepponechoi.cinema.exception.enums.ForbiddenErrorCode;
import lombok.Getter;

@Getter
public class ForbiddenException extends RuntimeException implements CustomException<ForbiddenErrorCode>{
  private ForbiddenErrorCode errorCode;
  private Object detail;
    public ForbiddenException() {
        this.errorCode = ForbiddenErrorCode.FORBIDDEN;
    }

    @Override
    public void setErrorCode(ForbiddenErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public void setDetail(Object detail) {
        this.detail = detail;
    }

}
