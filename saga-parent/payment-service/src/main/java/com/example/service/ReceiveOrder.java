package com.example.service;

import com.example.order.OrderEvent;
import com.example.payment.PaymentEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ReceiveOrder {
    @Autowired
    private VerifyOrder orderVerify;

    @KafkaListener(topics = {"order_topic"}, groupId = "payment_group")
    public void orderReceved(String event) throws JsonProcessingException {
        System.out.println("Order-Consumer calling...!");
        orderVerify.setOrder(new ObjectMapper().readValue(event,OrderEvent.class));
    }
}
