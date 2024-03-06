package com.example.resttemplatefoodservice.exception;

import java.io.Serial;

public class FoodOrderException extends Exception {
    @Serial
    private static final long serialVersionUID = 1L;
    public FoodOrderException(String message) {
        super(message);
    }
}
