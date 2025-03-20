package com.movie.movieapplication.response;

import static com.movie.movieapplication.error.GlobalSuccessCode.SUCCESS;

import com.movie.movieapplication.error.GlobalSuccessCode;
import lombok.Getter;

@Getter
public class BfResponse<T> {

    private int code;
    private String message;
    private T data;

    public BfResponse(T data) {
        this.code = SUCCESS.getCode();
        this.message = SUCCESS.getMessage();
        this.data = data;
    }

    public BfResponse(GlobalSuccessCode statusCode, T data) {
        this.code = statusCode.getCode();
        this.message = statusCode.getMessage();
        this.data = data;
    }

    public BfResponse(GlobalSuccessCode statusCode) {
        this.code = statusCode.getCode();
        this.message = statusCode.getMessage();
        this.data = null;
    }
}