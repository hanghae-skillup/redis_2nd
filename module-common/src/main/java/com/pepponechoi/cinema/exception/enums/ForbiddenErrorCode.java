package com.pepponechoi.cinema.exception.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ForbiddenErrorCode implements ErrorCode {
    FORBIDDEN(HttpStatus.FORBIDDEN,"FORBIDDEN","접근이 거부되었습니다."),
    BANNED_IP(HttpStatus.FORBIDDEN,"IP_BANNED","차단 된 IP 입니다.");
    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
}
