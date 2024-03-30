package com.example.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Integer orderId;
    private List<Item> items;
    private double paymentPrice;
}
