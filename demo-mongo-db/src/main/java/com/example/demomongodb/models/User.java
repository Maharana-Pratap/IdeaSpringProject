package com.example.demomongodb.models;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "user")
public class User {
    private Integer id;
    private String name;
    private String email;
    private String mob;
    private List<Product> products;
    private UserAddress address;
}
