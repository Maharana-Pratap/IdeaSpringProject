package com.example.delivery;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryEvent {
    private Delivery deliveryItem;
    private String deliveryStatus;
}
