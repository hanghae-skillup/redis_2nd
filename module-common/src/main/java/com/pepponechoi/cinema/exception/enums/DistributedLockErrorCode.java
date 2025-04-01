package com.pepponechoi.cinema.exception.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum DistributedLockErrorCode implements ErrorCode {
    DISTRIBUTED_LOCK_ERROR(HttpStatus.INTERNAL_SERVER_ERROR,"DISTRIBUTED_LOCK_ERROR","분산 락에 장애가 발생했습니다.");
    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
}
