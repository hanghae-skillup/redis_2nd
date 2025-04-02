package com.redis.common.util.response.status;

public interface ResponseStatus {
    int getCode();
    int getStatus();
    String getMessage();
}