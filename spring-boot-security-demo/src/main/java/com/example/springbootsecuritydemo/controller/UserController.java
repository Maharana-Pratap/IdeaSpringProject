package com.example.springbootsecuritydemo.controller;

import com.example.springbootsecuritydemo.model.User;
import com.example.springbootsecuritydemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String showMessage() {
        return "From default msg";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String helloAdmin() {
        return "I am from Admin!!!";
    }

    @GetMapping("/user")
    // @PreAuthorize("hasAuthority('ROLE_USER')")
    @PreAuthorize("hasRole('USER')")
    public String helloUser() {
        return "I am from User!!!";
    }

    @PostMapping("/add")
    public ResponseEntity<?> adduser(@RequestBody User user) {
        String res = "";
        User usr = userService.saveUser(user);
        if (null != usr) {
            return ResponseEntity.ok("User added in db");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
