package com.example.mongo_db.controller;

import com.example.mongo_db.entity.Emp;
import com.example.mongo_db.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    private EmpService empService;

    @PostMapping("/add")
    public ResponseEntity<?> saveEmp(@RequestBody Emp emp) {
        return ResponseEntity.ok(empService.addEmp(emp));
    }
}
