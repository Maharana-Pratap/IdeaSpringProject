package com.example.async_api_call.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class CatalogService {

    @Async("asyncBean")
    public CompletableFuture<?> showCatalog() {
        System.out.println("Shopping catalog is showing");
        return CompletableFuture.completedFuture("Shopping catalog is showing");
    }
}
