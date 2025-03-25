package com.redis.response.status;

public interface ResponseStatus {
    int getCode();
    int getStatus();
    String getMessage();
}