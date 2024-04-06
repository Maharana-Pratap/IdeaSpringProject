package com.example.springbootstartercache.service;

import com.example.springbootstartercache.pojo.Employee;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class EmpService {

    List<Employee> employeeList = new ArrayList<>();

    {
        IntStream.rangeClosed(1, 50)
                .forEach(data -> {
                    employeeList.add(Employee.builder()
                            .id(data)
                            .age(data + 35)
                            .name("Emp-" + data)
                            .build());
                });
    }

    @Cacheable(value = "emp_cache")
    public List<Employee> findAll() {
        System.out.println("findAll() Service called...!");
        return employeeList;
    }

    @Cacheable(value = "emp_cache", key = "#id")
    public Employee getEmp(Integer id) {
        System.out.println("getEmp() Service called with id: "+id);
        return employeeList.stream()
                .filter(emp-> emp.getId().equals(id))
                .findFirst()
                .orElseThrow(()-> new RuntimeException("Emp Not Found With Id: "+id));
    }

    @CacheEvict(value = "emp_cache", allEntries = true)
    public String cachedRemoved() {
        System.out.println("All cache removed...!");
        return "All cache removed...!";
    }
}
