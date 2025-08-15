package com.example.mongo_db.service;

import com.example.mongo_db.entity.Emp;
import com.example.mongo_db.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.lang.model.util.ElementScanner14;
import java.util.Comparator;
import java.util.List;

@Service
public class EmpService {

    @Autowired
    private EmpRepository empRepository;

    public List<Emp> addEmp(Emp emp) {
        empRepository.save(emp);
        return empRepository.findAll()
                .stream()
                .sorted((e1,e2)-> e2.getId() - e1.getId())
                .toList();
    }
}
