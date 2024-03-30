package com.example.demomongodb.controller;

import com.example.demomongodb.models.User;
import com.example.demomongodb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class OrderController {
    @Autowired
    private UserService userService;

    @PostMapping("/order")
    public ResponseEntity<?> placeOrder(@RequestBody User order) {
        return ResponseEntity.ok(userService.saveUserOrder(order));
    }

    @GetMapping("/all")
    public ResponseEntity<?> allOrders() {
        return ResponseEntity.ok(userService.findAllUser());
    }
}
