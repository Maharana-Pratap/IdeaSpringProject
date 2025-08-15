package com.example.mysqldb.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class BaseModel {
    private String created_by;
    private LocalDateTime created_date;
    private String updated_by;
    private LocalDateTime updated_date;
}
