package com.example.foodorderservice.controller;

import com.example.foodorderservice.exception.FoodOrderException;
import com.example.foodorderservice.service.Food;
import com.example.foodorderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/order")
public class FoodOrderController {
    @Autowired
    private OrderService orderService;
   @GetMapping("/")
    public ResponseEntity<?> findallOrder() {
        return ResponseEntity.ok(orderService.getAllOrder());
    }
    @GetMapping("/{orderId}")
    public ResponseEntity<?> getOrderById(@PathVariable Integer orderId) throws FoodOrderException {
        Food food = orderService.findOrderById(orderId);
            return ResponseEntity.ok(food);
        }
}
