package com.example.resttemplatefoodservice.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class FoodExceptionHandlar {
    @ExceptionHandler(FoodOrderException.class)
    public ResponseEntity<?> foodException(FoodOrderException exception) throws JsonProcessingException {
        ErrorResponse response = new ObjectMapper()
                .readValue(exception.getLocalizedMessage(), ErrorResponse.class);
        return ResponseEntity.badRequest().body(response);
    }
}
