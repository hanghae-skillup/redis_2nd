package com.pepponechoi.cinema.exception.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ConfliectErrorCode implements ErrorCode {
    CONFLICT(HttpStatus.CONFLICT,"CONFLICT","충돌을 해결할 수 없습니다.");
    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
}
