package com.example.demo.service;

import com.example.demo.dtos.Interview;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class InterviewService {

    public List<Interview> interviewsData() {
        List<Interview> interviewList = new ArrayList<>();

        IntStream.rangeClosed(1, 10)
                .forEach(index -> {
                            if (index / 2 == 0) {
                                interviewList.add(new Interview(index, "java-springBoot", "backend"));
                            } else {
                                interviewList.add(new Interview(index, "java-angular", "full-stack"));
                            }
                        }
                );
        return interviewList;
    }
}
