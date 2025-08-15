package com.example.mysqldb.dao;

import com.example.mysqldb.models.Parts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartsDao extends JpaRepository<Parts,Integer> {
}
