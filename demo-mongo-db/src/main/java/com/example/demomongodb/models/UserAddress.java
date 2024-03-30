package com.example.demomongodb.models;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAddress {
    private String country;
    private String state;
    private String street;
    private String pin;
}
