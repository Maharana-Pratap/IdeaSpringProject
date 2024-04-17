package com.example.schoolteacher.controller;

import com.example.schoolteacher.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @GetMapping("/students")
    public ResponseEntity<?> allStudents() {
        log.info("School teacher calling to students");
        String url = "http://localhost:9876/student/";
        RestTemplate restTemplate = new RestTemplate();
        Student[] students = restTemplate.getForObject(url, Student[].class);
        return ResponseEntity.ok(List.of(students));
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<?> studentsById(@PathVariable Integer id) {
        log.info("School teacher calling to students by id..!");
        String url = "http://localhost:9876/student/"+id;
        RestTemplate restTemplate = new RestTemplate();
        Student student = restTemplate.getForObject(url, Student.class);
        return ResponseEntity.ok(student);
    }

}
