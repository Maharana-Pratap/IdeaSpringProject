package com.example.Async.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class PaymentService {

    @Async("async-config")
    public CompletableFuture<?> payment() {
        log.info("payment service calling");
        return CompletableFuture.completedFuture("order payment-done");
    }
}
