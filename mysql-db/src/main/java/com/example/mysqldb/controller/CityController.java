package com.example.mysqldb.controller;

import com.example.mysqldb.models.City;
import com.example.mysqldb.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/city")
public class CityController {
    @Autowired
    private CityService cityService;

    @PostMapping("/add")
    public ResponseEntity<?> addNewCity(@RequestBody City city) {
        return ResponseEntity.ok(cityService.saveCity(city));
    }
}
