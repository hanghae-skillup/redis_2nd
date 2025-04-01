package com.pepponechoi.cinema.exception.exception;

import com.pepponechoi.cinema.exception.enums.ConfliectErrorCode;
import lombok.Getter;

@Getter
public class ConflictException extends RuntimeException implements CustomException<ConfliectErrorCode>{
  private ConfliectErrorCode errorCode;
  private Object detail;  
  
  public ConflictException() {
        this.errorCode = ConfliectErrorCode.CONFLICT;
    }


  @Override
  public void setErrorCode(ConfliectErrorCode errorCode) {
    this.errorCode = errorCode;
  }

  @Override
  public void setDetail(Object detail) {
    this.detail = detail;
  }
}
