package com.example.async_api_call.controller;

import com.example.async_api_call.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/async")
public class ShoppingController {

    @Autowired
    private CatalogService catalogService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private CartService cartService;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private DeliveryService deliveryService;

    @GetMapping("/call")
    public void shoppingDetails() throws InterruptedException {

        //CompletableFuture.allOf().Join() wait for all request complete
        // then return all response at the same time.
        CompletableFuture.allOf(catalogService.showCatalog()).join();
        CompletableFuture.allOf(itemService.itemPicked()).join();
        CompletableFuture.allOf(cartService.cartAdded()).join();
        CompletableFuture.allOf(paymentService.paymentVerified()).join();
        CompletableFuture.allOf(deliveryService.deliveredItem()).join();
    }
}
