package com.example.Async.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class DeliveryService {

    @Async("async-config")
    public CompletableFuture delivery() {
        log.info("delivery service calling");
        return CompletableFuture.completedFuture("order delivery placed");
    }
}
