package com.pepponechoi.cinema.exception.exception;

import com.pepponechoi.cinema.exception.enums.NotFoundErrorCode;
import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException implements CustomException<NotFoundErrorCode>{
  private NotFoundErrorCode errorCode;
  private Object detail;

  public NotFoundException() {
        this.errorCode = NotFoundErrorCode.NOT_FOUND;
    }


  @Override
  public void setErrorCode(NotFoundErrorCode errorCode) {
    this.errorCode = errorCode;
  }

  @Override
  public void setDetail(Object detail) {
    this.detail = detail;
  }
}
