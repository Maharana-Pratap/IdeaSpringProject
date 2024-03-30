package com.example.payment;

import com.example.order.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    private Integer paymentId;
    private List<Item> items;
    private double price;
    private String paymentStatus;
}
