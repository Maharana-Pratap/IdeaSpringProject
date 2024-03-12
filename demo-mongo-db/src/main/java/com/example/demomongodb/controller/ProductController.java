package com.example.demomongodb.controller;

import com.example.demomongodb.models.Product;
import com.example.demomongodb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<?> saveProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.addProduct(product));
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.updateProduct(product));
    }

    @DeleteMapping("/remove/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer productId) {
        return ResponseEntity.ok(productService.deleteProduct(productId));
    }

    @GetMapping("/find/{productId}")
    public ResponseEntity<?> findProduct(@PathVariable Integer productId) {
        return ResponseEntity.ok(productService.getProductbyId(productId));
    }
}
