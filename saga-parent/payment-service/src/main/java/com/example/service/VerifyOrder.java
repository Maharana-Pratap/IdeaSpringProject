package com.example.service;

import com.example.order.OrderEvent;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class VerifyOrder {
    private OrderEvent order=new OrderEvent();
}
