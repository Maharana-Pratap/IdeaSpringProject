package com.example.controller;

import com.example.payment.Payment;
import com.example.payment.PaymentEvent;
import com.example.service.VerifyOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private KafkaTemplate<String, PaymentEvent> paymentKafkaTemplate;
    @Autowired
    private VerifyOrder verifyOrder;

    @GetMapping("/verify")
    public String orderPayment() {
        if (null != verifyOrder) {
            if (verifyOrder.getOrder().getOrderStatus().equalsIgnoreCase("Created")) {
                double orderPrice = verifyOrder.getOrder().getOrder().getPaymentPrice();
                System.err.println("orderPrice: " + orderPrice);
                PaymentEvent event = new PaymentEvent();
                Payment payment = new Payment();
                payment.setPaymentId(1);
                payment.setItems(verifyOrder.getOrder().getOrder().getItems());
                payment.setPrice(orderPrice);
                payment.setPaymentStatus("DONE");
                event.setPayment(payment);
                event.setPaymentStatus("SUCCESSFUL");
                paymentKafkaTemplate.send("payment_topic", event);
                return "Order payment successful";
            }
        }
            return "Order payment Not Done Due to Order not Created";
    }
}
