package com.example.producer.controller;

import com.example.producer.dto.Job;
import com.example.producer.dto.JobEvent;
import com.example.producer.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/job")
public class JobController {

    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    @Autowired
    private JobService jobService;

    @GetMapping("/produce")
    public ResponseEntity<?> produceData() {
        List<Job> jobs = jobService.jobsList();
        if(jobs != null && !jobs.isEmpty()) {
            JobEvent event = new JobEvent();
            event.setEvent("Jobs Created");
            event.setJobs(jobs);
            kafkaTemplate.send("topic_job",event);
            return ResponseEntity.ok("Jobs Produced By Producer");
        }
        return new ResponseEntity<>("Jobs Not Created.",HttpStatus.NOT_FOUND);
    }
}
