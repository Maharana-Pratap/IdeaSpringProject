package com.example.mysqldb.controller;

import com.example.mysqldb.models.Student;
import com.example.mysqldb.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity<?> saveStudent(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.addStudent(student));
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name) {
        return ResponseEntity.ok(studentService.findByName(name));
    }

    @GetMapping("/{name}/{mob}")
    public ResponseEntity<?> findByNameAndMob(@PathVariable String name, @PathVariable String mob) {
        return ResponseEntity.ok(studentService.findByNameAndMob(name,mob));
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(studentService.findAll());
    }

    @GetMapping("/lessAge/{age}")
    public ResponseEntity<?> findLessAge(@PathVariable Integer age) {
        return ResponseEntity.ok(studentService.findLessThanAge(age));
    }
}
