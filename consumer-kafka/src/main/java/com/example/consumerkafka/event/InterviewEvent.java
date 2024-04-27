package com.example.consumerkafka.event;

import com.example.consumerkafka.dtos.Interview;
import lombok.Data;
import java.util.List;

@Data
public class InterviewEvent {
    private String event;
    private Interview data;
}
