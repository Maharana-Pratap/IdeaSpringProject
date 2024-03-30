package com.example.order;

import lombok.Data;

@Data
public class OrderEvent {
    private String orderStatus;
    private Order order;
}
