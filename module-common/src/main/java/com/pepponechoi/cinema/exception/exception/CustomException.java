package com.pepponechoi.cinema.exception.exception;

import com.pepponechoi.cinema.exception.enums.ErrorCode;

public interface CustomException<T extends ErrorCode> {
    void setErrorCode(T errorCode);
    void setDetail(Object detail);
    T getErrorCode();
    Object getDetail();
}
