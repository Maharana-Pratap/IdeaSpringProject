package com.example.async_api_call.service;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class CartService {

    public CompletableFuture<?> cartAdded() {
        System.out.println("Item added to cart");
        return CompletableFuture.completedFuture("Item added to cart");
    }
}
