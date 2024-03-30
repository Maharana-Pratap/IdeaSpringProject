package com.example.demomongodb.service;

import com.example.demomongodb.dao.UserRepository;
import com.example.demomongodb.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> saveUserOrder(User order) {
        Integer maxId = getMaxId();
        order.setId(++maxId);
        userRepository.save(order);
        return userRepository.findAll();
    }

    private Integer getMaxId() {
        return userRepository.findAll()
                .stream()
                .mapToInt(User::getId)
                .max()
                .orElse(0);
    }

    public List<User> findAllUser() {
        return userRepository.findAll()
                .stream()
                .sorted((u1,u2) -> u2.getId() - u1.getId())
                .toList();
    }
}
