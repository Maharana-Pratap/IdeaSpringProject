package com.example.exception.controller;

import com.example.exception.config.ResourceNotFoundException;
import com.example.exception.dto.EmpDTO;
import com.example.exception.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.module.ResolutionException;
import java.util.Optional;

@RestController
@RequestMapping("/emp")
public class ExController {

    @Autowired
    private EmpService service;

    @GetMapping("/id/{id}")
    public ResponseEntity<?> getEmp(@PathVariable Integer id) {
        Optional<EmpDTO> emp = service.findById(id);
        if(emp.isPresent()) {
            return ResponseEntity.ok(emp.get());
        } else {
            throw new ResourceNotFoundException("Emp Not Found...!");
        }
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<?> getEmp(@PathVariable String name) {
        return ResponseEntity.ok(service.findByName(name));
    }
}