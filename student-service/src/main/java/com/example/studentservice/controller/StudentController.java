package com.example.studentservice.controller;

import com.example.studentservice.service.Student;
import com.example.studentservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("/add")
    public ResponseEntity<?> addStudent(@RequestBody Student student) {
        long dbRecordCount = studentService.studetDbCount();
        Integer maxAllowedAdmission = getAdmissionCount();
        if(dbRecordCount < maxAllowedAdmission) {
            Student response = studentService.addStudent(student);
            if (Objects.nonNull(response)) {
                return ResponseEntity.ok(studentService.getAllStudentRecord());
            }
        } else {
            return ResponseEntity.ok("Admission Full.. please connect with admin");
        }
        return ResponseEntity.badRequest().body("Record Not Saved...!");
    }

    public Integer getAdmissionCount() {
        Integer admissionCount = 0;
        List<ServiceInstance> instances = discoveryClient.getInstances("ADMISSION-SERVICE");
        URI uri = instances.get(0).getUri();
        String url = uri.toString()+"/admission/count";
        admissionCount = restTemplate.getForObject(url,Integer.class);
        return admissionCount;
    }
}
