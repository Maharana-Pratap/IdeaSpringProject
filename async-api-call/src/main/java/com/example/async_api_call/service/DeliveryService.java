package com.example.async_api_call.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class DeliveryService {

    @Async("asyncBean")
    public CompletableFuture<?> deliveredItem() {
        System.out.println("Items delivered to provided address");
        return CompletableFuture.completedFuture("Items delivered to provided address");
    }
}
