package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
public class CloudConfigController {
    @Autowired
    private ConfigDetails config;

    @GetMapping("/url")
    public LoginDetails details() {
        return new LoginDetails(config.getLoginurl(), config.getAuthurl());
    }
}
