package com.example.delivery;

import com.example.order.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Delivery {
    private List<Item> deliveryItems;
    private String deliveryAddress;
    private String deliveryStatus;
}
