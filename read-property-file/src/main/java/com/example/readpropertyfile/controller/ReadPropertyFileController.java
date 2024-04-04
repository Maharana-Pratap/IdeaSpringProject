package com.example.readpropertyfile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * Finding the way to read value from .property file
 */
@RestController
@RequestMapping("/emp")
// Spring find default application.properties file
// if use diffrent name of file the use @PropertySource
@PropertySource(value = "/emp.properties")
public class ReadPropertyFileController {
    @Autowired
    private Environment environment;
    @Value("${emp.id}")
    private Integer id;
    @Value("${emp.name}")
    private String name;
    @Value("${emp.email}")
    private String email;
    @Value("${emp.phone}")
    private String phone;

    /*
     *  1. using @Value
     */
    @GetMapping("/value")
    public ResponseEntity<?> getEmp() {
        Employee employee = Employee.builder()
                .id(id)
                .email(email)
                .name(name)
                .phone(phone)
                .build();
        return ResponseEntity.ok(employee);
    }

    /*
        2. using environment.getProperty()
     */
    @GetMapping("/name")
    public ResponseEntity<?> findDevName() {
        return ResponseEntity.ok(environment.getProperty("developer.name"));
    }
}
