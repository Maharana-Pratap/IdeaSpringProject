package com.example.mockitotest.service;

import com.example.mockitotest.entity.MockUser;
import com.example.mockitotest.repository.MockUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MockUserService {

    @Autowired
    private MockUserRepository repository;

    public MockUser addUser(MockUser user) {
        return repository.save(user);
    }

    public MockUser updateUser(MockUser user) {
        return repository.save(user);
    }

    public List<MockUser> getAllUser() {
        return repository.findAll()
                .stream()
                .sorted((u1,u2)-> u2.getId().compareTo(u1.getId()))
                .toList();
    }

    public MockUser userById(Integer id) {
        return repository.findById(id)
                .orElseThrow(()-> new RuntimeException("user not found with id: "+id));
    }
}
