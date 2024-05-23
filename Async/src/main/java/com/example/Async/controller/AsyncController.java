package com.example.Async.controller;

import com.example.Async.services.DeliveryService;
import com.example.Async.services.ItemService;
import com.example.Async.services.OrderService;
import com.example.Async.services.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@Slf4j
@RestController
@RequestMapping("/async")
public class AsyncController {
    @Autowired
    private ItemService itemService;

    @Autowired
    private DeliveryService deliveryService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/order")
    public CompletableFuture<?> asyncCallTest() {

        //CompletableFuture.allOf() waiting the response till get response
        log.info("order controller calling");
        CompletableFuture.allOf(orderService.orderPlaced()).join();

        //CompletableFuture.allOf() waiting the response till get response
        log.info("payment controller calling");
        CompletableFuture.allOf(paymentService.payment()).join();

        //CompletableFuture.allOf() waiting the response till get response
        log.info("delivery controller calling");
        CompletableFuture.allOf(deliveryService.delivery()).join();

        return CompletableFuture.completedFuture(itemService.itemList());
    }
}
