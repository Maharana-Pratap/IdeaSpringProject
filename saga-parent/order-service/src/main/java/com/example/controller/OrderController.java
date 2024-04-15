package com.example.controller;

import com.example.order.Order;
import com.example.order.OrderEvent;
import com.example.service.OrerFind;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private KafkaTemplate<String,OrderEvent> kafkaTemplate;

    @Autowired
    private OrerFind orderFind;

    @GetMapping("/create")
    public ResponseEntity<?> createCustomorOrder() {
        Order order = orderFind.createOrder();
        if(null != order) {
            OrderEvent event = new OrderEvent();
            event.setOrder(order);
            event.setOrderStatus("Created");
            kafkaTemplate.send("order_topic",event);
            return ResponseEntity.ok(order);
        }
        return ResponseEntity.badRequest()
                .body("Nor Order Found");
    }
}
