package com.example.mockitotest.repository;

import com.example.mockitotest.entity.MockUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MockUserRepository extends JpaRepository<MockUser,Integer> {

}
