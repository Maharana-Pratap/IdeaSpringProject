package com.example.amazonec2.pojo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Builder;
import lombok.Data;

import java.security.KeyStore;

@Data
@Builder
public class Student {
    private Integer id;
    private String anme;
    private String phone;
    private String email;
}
