package com.pepponechoi.cinema.exception.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum NotFoundErrorCode implements ErrorCode {
    NOT_FOUND(HttpStatus.NOT_FOUND,"NOT_FOUND","해당 하는 것을 찾을 수 없습니다."),
    RESOURCE_NOT_FOUND(HttpStatus.NOT_FOUND,"NOT_FOUND","해당하는 자원을 찾을 수 없습니다.");
    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
}
