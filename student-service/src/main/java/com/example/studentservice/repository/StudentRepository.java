package com.example.studentservice.repository;

import com.example.studentservice.service.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.CrudRepositoryExtensionsKt;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface StudentRepository extends CrudRepository<Student,Integer> {

    @Query("Select count(s) From Student s")
    public long studentDbCount();
    @Query("Select s from Student s order by id desc")
    public List<Student> allStudentRecords();
}
