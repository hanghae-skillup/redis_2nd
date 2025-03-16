package com.movie.movieapplication.exception;

import com.movie.movieapplication.error.GlobalErrorCode;
import com.movie.movieapplication.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<ErrorResponse> customExceptionHandler(ApplicationException e) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .errorCode(GlobalErrorCode.VALIDATION_FAILED.getErrorCode())
                .errorMessage(e.getMessage())
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)  // 상태 코드 400 (Bad Request)
                .body(errorResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
        log.error("ERROR {}", ex.getMessage());
        ErrorResponse errorResponse = ErrorResponse.builder()
                .errorCode(GlobalErrorCode.INTERNAL_SERVER_ERROR.getErrorCode())
                .errorMessage(GlobalErrorCode.INTERNAL_SERVER_ERROR.getErrorMessage())
                .build();

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)  // 상태 코드 500 (Internal Server Error)
                .body(errorResponse);
    }

}
