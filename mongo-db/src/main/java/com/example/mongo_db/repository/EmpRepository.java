package com.example.mongo_db.repository;

import com.example.mongo_db.entity.Emp;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepository extends MongoRepository<Emp,Integer> {
}
