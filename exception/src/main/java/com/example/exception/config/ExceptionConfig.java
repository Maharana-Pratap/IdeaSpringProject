package com.example.exception.config;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse empNotFound(ResourceNotFoundException exception, HttpServletRequest request) {
        ExceptionResponse response = new ExceptionResponse();
        response.setApi(request.getRequestURI());
        response.setErrorMsg(exception.getLocalizedMessage());
        response.setDateTime(new Date().toString());
        response.setStatusCode(String.valueOf(HttpStatus.NOT_FOUND));
        return response;
    }
}
