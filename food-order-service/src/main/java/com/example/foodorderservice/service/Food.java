package com.example.foodorderservice.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Food {
    private Integer orderId;
    private Map<String,Integer> foodItems;
    private String orderStatus;
    private LocalDateTime orderDataTime;
}
