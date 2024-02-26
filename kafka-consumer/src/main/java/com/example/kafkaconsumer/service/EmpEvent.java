package com.example.kafkaconsumer.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpEvent {
    private String status;
    private Employee emp;
}
