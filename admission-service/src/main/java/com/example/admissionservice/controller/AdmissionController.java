package com.example.admissionservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admission")
public class AdmissionController {

    @GetMapping("/count")
    public ResponseEntity<?> getAdmissionCount() {
        return  ResponseEntity.ok(10);
    }
}
