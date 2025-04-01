package com.pepponechoi.cinema.exception.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum BadRequestErrorCode implements ErrorCode {
    BAD_REQUEST(HttpStatus.BAD_REQUEST,"BAD_REQUEST","잘 못 된 요청입니다."),
    INVALID_REQUEST_DATA(HttpStatus.BAD_REQUEST, "BAD_REQUEST", "요청 데이터의 형식이 잘못되었습니다."),
    VALIDATION_FAILED(HttpStatus.BAD_REQUEST,"VALIDATION_FAILED","요청의 유효성 검사가 실패했습니다.");
    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
}
