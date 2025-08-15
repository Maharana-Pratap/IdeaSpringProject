package com.example.mysqldb.dao;

import com.example.mysqldb.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {

    public List<Student> findByName(String name);
    public Student findByNameAndPhone(String name, String phone);
    public List<Student> ageLessThan(Integer age);

}
