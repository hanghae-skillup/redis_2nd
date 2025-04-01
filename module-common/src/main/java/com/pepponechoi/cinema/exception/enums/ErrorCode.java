package com.pepponechoi.cinema.exception.enums;

import org.springframework.http.HttpStatus;

public interface ErrorCode {
    HttpStatus getHttpStatus();
    String getMessage();
    String getCode();
}
