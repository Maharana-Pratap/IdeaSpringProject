package com.example.studentservice.service;

import com.example.studentservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student addStudent(Student entity) {
        Student response = null;
        if (Objects.nonNull(entity)) {
            response = studentRepository.save(entity);
        }
        return response;
    }

    public long studetDbCount() {
        return studentRepository.count();
                //.studentDbCount();
    }

    public List<Student> getAllStudentRecord() {
        return studentRepository.allStudentRecords();
    }
}
