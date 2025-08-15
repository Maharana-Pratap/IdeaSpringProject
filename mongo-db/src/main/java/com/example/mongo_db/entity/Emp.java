package com.example.mongo_db.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "emp_details")
public class Emp {
    @Id
    private Integer id;
    private String name;
    private String dept;
}
