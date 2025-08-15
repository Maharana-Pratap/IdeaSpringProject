package com.example.exception.service;

import com.example.exception.config.ResourceNotFoundException;
import com.example.exception.dto.EmpDTO;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Optional;

@Service
public class EmpService {

    List<EmpDTO> emps = List.of(
            new EmpDTO(1,"rana"),
            new EmpDTO(2,"vipul"),
            new EmpDTO(3,"maha"),
            new EmpDTO(4,"priya"),
            new EmpDTO(5,"kittu")
    );

    public Optional<EmpDTO> findById(Integer empId) {
        return emps.stream()
                .filter(emps-> emps.getId().equals(empId))
                .findFirst();
    }

    public EmpDTO findByName(String name) {
        return emps.stream()
                .filter(emps-> emps.getName().equals(name))
                .findFirst()
                .orElseThrow(()-> new ResourceNotFoundException("Emp Not Found By Name : "+name));
    }
}
