package com.example.readpropertyfile.controller;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Employee {
    private Integer id;
    private String name;
    private String email;
    private String phone;
}
