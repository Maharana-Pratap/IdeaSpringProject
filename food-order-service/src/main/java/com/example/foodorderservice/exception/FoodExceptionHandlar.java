package com.example.foodorderservice.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class FoodExceptionHandlar {
    @ExceptionHandler(FoodOrderException.class)
    public ResponseEntity<?> foodException(HttpServletRequest request,
                                           FoodOrderException exception){

    ErrorResponse response = new ErrorResponse();
    response.setUri(request.getRequestURI());
    response.setErrorCode(HttpStatus.BAD_REQUEST.toString());
    response.setCallingDateTime(LocalDateTime.now());
    response.setErrorMessage(exception.getLocalizedMessage());
        return ResponseEntity.badRequest().body(response);
    }
}
