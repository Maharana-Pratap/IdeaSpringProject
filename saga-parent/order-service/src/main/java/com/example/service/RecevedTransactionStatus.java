package com.example.service;

import com.example.payment.PaymentEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;

public class RecevedTransactionStatus {
    @KafkaListener(topics = {"payment_topic"}, groupId = "order_consumer_group")
    public void getOrderTransactionStatus(String event) throws JsonProcessingException {
        PaymentEvent paymentEvent = new ObjectMapper()
                .readValue(event,PaymentEvent.class);
        if(paymentEvent.getPaymentStatus().equalsIgnoreCase("SUCCESSFUL")) {
            System.out.println("Order Payment Successfully...!");
        } else {
            System.err.println("Order can not be proceed due to payment failed...!");
        }
    }
}
