package com.example.ecache.controller;

import com.example.ecache.pojo.User;
import com.example.ecache.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ResponseEntity<?> userAll() {
        return ResponseEntity.ok(userService.findAllUser());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> userById(@PathVariable Integer id) throws IOException {
        return ResponseEntity.ok(userService.userById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<?> userAdd(@RequestBody User user) {
        return ResponseEntity.ok(userService.addUser(user));
    }
}
