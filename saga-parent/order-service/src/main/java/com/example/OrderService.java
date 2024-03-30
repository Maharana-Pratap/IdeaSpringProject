package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication(scanBasePackages = {"com.example"})
@EnableKafka
public class OrderService {
    public static void main(String[] args) {
        SpringApplication.run(OrderService.class,args);
    }
}