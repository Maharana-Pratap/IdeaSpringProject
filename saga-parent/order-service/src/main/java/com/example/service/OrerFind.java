package com.example.service;


import com.example.order.Item;
import com.example.order.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrerFind {

    public Order createOrder() {
      List<Item> orderItems =  List.of(new Item(1,"Table",2, 2000),
                new Item(2,"TV",1, 5000));

      double sumPrice =  orderItems.stream()
                .filter(item-> item.getItemPrice() > 0)
                .mapToDouble(Item::getItemPrice)
                .sum();

        Order order = new Order();
        order.setOrderId(1);
        order.setItems(orderItems);
        order.setPaymentPrice(sumPrice);
        return order;
    }
}
