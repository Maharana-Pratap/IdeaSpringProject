package com.example.resttemplatefoodservice.controller;

import com.example.resttemplatefoodservice.exception.FoodOrderException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Arrays;
@Slf4j
@RestController
@RequestMapping("/rest")
public class RestorantController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/order")
    public ResponseEntity<?> findAll() throws Exception {
        String url = "http://localhost:8080/order/";
        try {
            URI uri = new URI(url);
            Food[] orders = restTemplate.getForObject(uri, Food[].class);
            return ResponseEntity.ok(Arrays.asList(orders));
        } catch (Exception ex) {
            log.error("Error in getAll {} ",ex.getMessage());
            throw new Exception("Error occured in fetching findAll()");
        }
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<?> findOrderById(@PathVariable Integer orderId) throws Exception {
        try {
            String url = "http://localhost:8080/order/" + orderId;
            URI uri = new URI(url);
            Food response = restTemplate.getForObject(uri, Food.class);
            return ResponseEntity.ok(response);
        } catch (HttpClientErrorException ex) {
            log.error("Error in fetching by id: "+ex.getResponseBodyAsString());
            throw new FoodOrderException(ex.getResponseBodyAsString());
        } catch (Exception ex) {
            throw new FoodOrderException("order not found in Rest-Call");
        }
    }
}
