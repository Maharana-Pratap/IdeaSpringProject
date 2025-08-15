package com.example.producer.service;

import com.example.producer.dto.Job;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;


@Service
public class JobService {

    private  List<Job> jobs() {
        List<Job> jobList = new ArrayList<>();
        IntStream.rangeClosed(1, 5)
                .forEach(index -> {
                    jobList.add(Job.builder()
                            .id(index)
                            .name("Software Developer-" + index)
                            .profile("Sr.Developer")
                            .build());
                });
        return jobList;
    }

    public List<Job> jobsList() {
        return jobs();
    }
}





