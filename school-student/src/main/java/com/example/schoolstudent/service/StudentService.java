package com.example.schoolstudent.service;

import com.example.schoolstudent.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class StudentService {

   List<Student> studentList;
    {
        studentList = List.of(
                Student.builder().id(1).name("tufani").email("tufani@email.com").build(),
                Student.builder().id(2).name("kittu").email("kittu@email.com").build(),
                Student.builder().id(3).name("bittu").email("bittu@email.com").build(),
                Student.builder().id(4).name("kanaiya").email("kanaiya@email.com").build(),
                Student.builder().id(5).name("mantu").email("mantu@email.com").build()
        );
    }

    public List<Student> getAllStudent() {
        log.info("Students record send by school...!");
        return studentList;
    }

    public Student findStudentById(Integer id) {
        return studentList.stream()
                .filter(student-> student.getId().equals(id))
                .findFirst()
                .orElseThrow(()-> new RuntimeException("Student not found with id: "+id));
    }
}
