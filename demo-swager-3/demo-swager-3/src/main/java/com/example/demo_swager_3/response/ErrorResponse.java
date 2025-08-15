package com.example.demo_swager_3.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorResponse {
    private String status_code;
    private String error_msg;
    private String api;
    private LocalDateTime date_time;
}
