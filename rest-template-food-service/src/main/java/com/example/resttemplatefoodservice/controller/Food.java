package com.example.resttemplatefoodservice.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Food {
    private Integer orderId;
    private Map<String,Integer> foodItems;
    private String orderStatus;
    private LocalDateTime orderDataTime;
}
