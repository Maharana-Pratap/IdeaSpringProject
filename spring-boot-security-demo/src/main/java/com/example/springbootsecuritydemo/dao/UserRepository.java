package com.example.springbootsecuritydemo.dao;

import com.example.springbootsecuritydemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    @Query("Select u from User u where u.name= :userName")
    public User getUserByName(@Param("userName") String userName);

    public Optional<User> getByName(String name);
}
