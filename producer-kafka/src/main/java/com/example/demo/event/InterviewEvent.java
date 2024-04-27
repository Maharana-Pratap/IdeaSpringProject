package com.example.demo.event;

import com.example.demo.dtos.Interview;
import lombok.Data;

import java.util.List;

@Data
public class InterviewEvent {
    private String event;
    private Interview data;
}
