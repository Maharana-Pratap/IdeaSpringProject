package com.example.cqrsaxon.controller;

import com.example.cqrsaxon.entity.User;
import com.example.cqrsaxon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/cqrs")
public class UserCommandController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public CompletableFuture<User> createUser(@RequestBody User entity) {
         return userService.addUser(entity);
    }
}
