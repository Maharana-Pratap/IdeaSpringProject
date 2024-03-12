package com.example.demomongodb.dao;

import com.example.demomongodb.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product,Integer> {
    /*@Query("Select MAX(_id) from Product p")
    public Integer getMaxIdFromProduct();*/
}
