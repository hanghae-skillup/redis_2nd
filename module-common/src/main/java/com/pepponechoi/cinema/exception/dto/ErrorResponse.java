package com.pepponechoi.cinema.exception.dto;

import com.pepponechoi.cinema.exception.enums.ErrorCode;
import com.pepponechoi.cinema.exception.exception.CustomException;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.ResponseEntity;

@Data
@Builder
public class ErrorResponse {
    private String code;
    private String message;
    private Object detail;

    public static ResponseEntity<ErrorResponse> toResponseEntity(RuntimeException ex) {
        System.out.println("ex = " + ex);
        for (StackTraceElement stackTraceElement : ex.getStackTrace()) {
            System.out.println("stackTraceElement = " + stackTraceElement.toString());
        }

        CustomException<?> exception = (CustomException<?>) ex;
        ErrorCode errorType = exception.getErrorCode();
        Object detail = exception.getDetail();

        return ResponseEntity.status(errorType.getHttpStatus())
            .body(
                ErrorResponse.builder()
                    .code(errorType.getCode())
                    .message(errorType.getMessage())
                    .detail(detail)
                    .build()
            );
    }
}
