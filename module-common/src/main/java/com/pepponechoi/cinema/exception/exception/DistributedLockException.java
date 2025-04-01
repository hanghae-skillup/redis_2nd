package com.pepponechoi.cinema.exception.exception;

import com.pepponechoi.cinema.exception.enums.DistributedLockErrorCode;
import lombok.Getter;

@Getter
public class DistributedLockException extends RuntimeException implements CustomException<DistributedLockErrorCode>{
  private DistributedLockErrorCode errorCode;
  private Object detail;

  public DistributedLockException() {
        this.errorCode = DistributedLockErrorCode.DISTRIBUTED_LOCK_ERROR;
    }


  @Override
  public void setErrorCode(DistributedLockErrorCode errorCode) {
    this.errorCode = errorCode;
  }

  @Override
  public void setDetail(Object detail) {
    this.detail = detail;
  }
}
