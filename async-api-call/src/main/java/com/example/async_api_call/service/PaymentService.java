package com.example.async_api_call.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class PaymentService {

    @Async("asyncBean")
    public CompletableFuture<?> paymentVerified() {
        System.out.println("Payment Done");
        return CompletableFuture.completedFuture("Payment Done");
    }
}
