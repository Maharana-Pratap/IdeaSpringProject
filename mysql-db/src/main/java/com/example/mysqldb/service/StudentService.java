package com.example.mysqldb.service;

import com.example.mysqldb.dao.StudentRepo;
import com.example.mysqldb.models.Student;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Transactional
    public String addStudent(Student entity) {
        try {
            entity.setCreated_by("maharana");
            entity.setCreated_date(LocalDateTime.now());
            studentRepo.save(entity);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "Student Added Sucessfully...!";
    }

    public List<Student> findAll() {
        return studentRepo.findAll();
    }

    public List<Student> findByName(String name) {
        return studentRepo.findByName(name);
    }

    public Student findByNameAndMob(String name, String mob) {
        return studentRepo.findByNameAndPhone(name,mob);
    }

    public List<Student> findLessThanAge(Integer age) {
        return studentRepo.ageLessThan(age);
    }
}
