package com.example.schoolstudent.model;

import lombok.Builder;
import lombok.Data;

import java.security.KeyStore;

@Data
@Builder
public class Student {
    private Integer id;
    private String name;
    private String email;
}
