package com.example.demo_swager_3.service;

import com.example.demo_swager_3.dto.EmpDTO;
import org.springframework.stereotype.Service;
import org.springframework.validation.DataBinder;

import java.util.List;
import java.util.stream.Stream;

@Service
public class EmpService {

    List<EmpDTO> empDTOList = List.of(new EmpDTO(1,"sudhir"),
            new EmpDTO(2,"laila"),
            new EmpDTO(3,"majnu"),
            new EmpDTO(4,"Guriya"));

    public List<EmpDTO> getAllEmp() {
        return empDTOList;
    }

    public EmpDTO findEmpById(Integer id) {
        return empDTOList.stream()
                .filter(emp -> emp.getId().equals(id))
                .findFirst()
                .orElseThrow(()-> new RuntimeException("Emp not found with id : "+id));
    }
}
