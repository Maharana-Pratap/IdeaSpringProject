package com.example.ecache.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
public class User implements Serializable {
    private Integer id;
    private String name;
    private String phone;
}
