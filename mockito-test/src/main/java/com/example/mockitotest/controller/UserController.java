package com.example.mockitotest.controller;

import com.example.mockitotest.entity.MockUser;
import com.example.mockitotest.service.MockUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mock")
public class UserController {

    @Autowired
    private MockUserService service;

    @PostMapping("/user")
    public ResponseEntity<?> saveUser(@RequestBody MockUser user) {
        return ResponseEntity.ok(service.addUser(user));
    }

    @PutMapping("/user")
    public ResponseEntity<?> updateUser(@RequestBody MockUser user) {
        return ResponseEntity.ok(service.updateUser(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> userById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.userById(id));
    }

    @GetMapping("/user")
    public ResponseEntity<?> users() {
        return ResponseEntity.ok(service.getAllUser());
    }
}
