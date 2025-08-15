package com.example.mysqldb.controller;

import com.example.mysqldb.models.Parts;
import com.example.mysqldb.service.PartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/parts")
public class PartsController {

    @Autowired
    private PartsService partsService;

    @PostMapping("/add")
    public ResponseEntity<?> storeParts(@RequestBody Parts parts) {
        return ResponseEntity.ok(partsService.saveParts(parts));
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateParts(@RequestBody Parts parts) {
        return ResponseEntity.ok(partsService.updateParts(parts));
    }
}
