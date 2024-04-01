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

    @GetMapping("/")
    public ResponseEntity<?> findAllCity() {
        return ResponseEntity.ok(cityService.findAllCity());
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateCity(@RequestBody City city) {
        return ResponseEntity.ok(cityService.updateCity(city));
    }

    @GetMapping("/rmCached")
    public ResponseEntity<String> removeCache() {
        return ResponseEntity.ok(cityService.removeAllCache());
    }
}
