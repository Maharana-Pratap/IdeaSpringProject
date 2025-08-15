package com.example.exception.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ExceptionResponse {
    private String statusCode;
    private String errorMsg;
    private String api;
    private String dateTime;
}
