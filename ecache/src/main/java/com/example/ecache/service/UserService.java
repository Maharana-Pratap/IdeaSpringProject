package com.example.ecache.service;

import com.example.ecache.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
//@CacheConfig(cacheNames = {"user_cache"})
public class UserService {

    User u1 = User.builder().id(1)
            .name("maha")
            .phone("2345123")
            .build();
    User u2 = User.builder().id(2).name("rana").phone("65432109").build();
    User u3 = User.builder().id(3).name("Singh").phone("98098678").build();
    private List<User> userList = List.of(u1,u2,u3);

    @Cacheable(value = "user_cache")
    public List<User> findAllUser() {
        log.error("db call findAllUser: " + userList);
        return userList;
    }

    @Cacheable(value = "user_cache", key = "#id", condition = "#id==2")
    public User userById(Integer id) throws IOException {
        log.error("db call userById: ", id);
        return userList.stream()
                .filter(record -> Objects.equals(record.getId(), id))
                .findFirst()
                .orElseThrow(() -> new IOException("User not found with id: " + id));
    }

    public List<User> addUser(User user) {
        List<User> ulist = new ArrayList<>();
        ulist.add(user);
        ulist.addAll(userList);

        return ulist.stream()
                .sorted((u1, u2) -> u2.getId().compareTo(u1.getId()))
                .toList();
    }

    @CacheEvict(value = "user_cache")
    public String deleteAllCache() {
        return "Delete all cached data...!";
    }
}
