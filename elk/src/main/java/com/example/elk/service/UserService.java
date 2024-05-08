package com.example.elk.service;

import com.example.elk.dtos.User;
import lombok.extern.log4j.Log4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {
    Logger logger = LoggerFactory.getLogger(UserService.class);
    List<User> userList =
            List.of(User
                    .builder()
                    .id(1)
                    .age(3)
                    .name("raka")
                    .build(),
                    new User(2,"prerna",34),
                    new User(3,"sony",67)
            );

    public List<User> findAll() {
        return userList;
    }

    public User findUserById(Integer id) {
        User users = null;
        try {
            users = userList.stream()
                    .filter(user-> user.getId().equals(id))
                    .findFirst()
                    .get();
        } catch (Exception ex) {
            logger.error("user not found with id: ", id.toString());
        }
        return users;
    }

    public User findByName(String name) {
            User users = null;
        try {
            users = userList.stream()
                    .filter(usr -> usr.getName().equalsIgnoreCase(name))
                    .findFirst()
                    .get();

        } catch (Exception ex) {
            logger.error("user not found with name: ", name);
        }
        return users;
    }
}
