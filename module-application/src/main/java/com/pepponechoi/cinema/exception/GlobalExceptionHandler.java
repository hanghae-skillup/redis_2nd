package com.pepponechoi.cinema.exception;

import com.pepponechoi.cinema.exception.dto.ErrorResponse;
import com.pepponechoi.cinema.exception.exception.BadRequestException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleArgumentException(HttpServletRequest req, RuntimeException e) {
        return ErrorResponse.toResponseEntity(e);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleBadRequestException(MethodArgumentNotValidException e) {
        e.getBindingResult().getAllErrors().forEach(
            error -> System.out.println("error = " + error)
        );
        return ErrorResponse.toResponseEntity(new BadRequestException());
    }
}
