package com.example.springbootstartercache.controller;

import com.example.springbootstartercache.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping("/")
    public ResponseEntity<?> findEmps() {
        return ResponseEntity.ok(empService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findEmpId(@PathVariable Integer id) {
        return ResponseEntity.ok(empService.getEmp(id));
    }

    @GetMapping("/removed")
    public ResponseEntity<?> cacheRemoved() {
        return ResponseEntity.ok(empService.cachedRemoved());
    }
}
