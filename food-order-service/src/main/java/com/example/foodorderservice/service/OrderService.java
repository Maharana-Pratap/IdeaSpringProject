package com.example.foodorderservice.service;

import com.example.foodorderservice.exception.FoodOrderException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {

  private static Map<String,Integer> orderItems1 = null;
   private static Map<String,Integer> orderItems2 = null;
   static {
       orderItems1 = Map.of("pizza",2, "burger",5, "samosa",10);
       orderItems2  = Map.of("puri",20, "Sabji",3, "Daal",4, "raita",4);
    }

    public List<Food> getAllOrder() {
      return Arrays.asList(new Food(1,orderItems1, "delivered", LocalDateTime.now()) ,
      new Food(2, orderItems2, "in-progress",  LocalDateTime.now()));
    }

    public Food findOrderById(Integer orderId) throws FoodOrderException {
       return getAllOrder().stream()
                .filter(order-> order.getOrderId().equals(orderId))
                .findFirst()
                .orElseThrow(()-> new FoodOrderException("Food order not found with order id: "+orderId));
    }
}
