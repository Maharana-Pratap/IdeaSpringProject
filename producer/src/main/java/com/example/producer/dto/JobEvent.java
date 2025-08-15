package com.example.producer.dto;

import lombok.Data;

import java.util.List;

@Data
public class JobEvent {
    private String event;
    private List<Job> jobs;
}
