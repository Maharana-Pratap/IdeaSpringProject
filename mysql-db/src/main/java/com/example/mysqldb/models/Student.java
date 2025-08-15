package com.example.mysqldb.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "student")
@Data
@NoArgsConstructor
public class Student extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String phone;
    private Integer age;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dob;
}
