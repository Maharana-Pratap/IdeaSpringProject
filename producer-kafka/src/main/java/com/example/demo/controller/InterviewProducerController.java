package com.example.demo.controller;

import com.example.demo.dtos.Interview;
import com.example.demo.event.InterviewEvent;
import com.example.demo.service.InterviewService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/interview")
public class InterviewProducerController {

    @Autowired
    //@Resource
    private KafkaTemplate<String,Object> producer;

    @Autowired
    private InterviewService interviewService;

    @GetMapping("/produce")
    public String produceInterviewData() {
        InterviewEvent event = new InterviewEvent();
        List<Interview> interviewList = interviewService.interviewsData();
        if(!interviewList.isEmpty()) {
            interviewList.forEach(data-> {
                event.setData(data);
                event.setEvent("Interiew-data-produced");
                producer.send("interview",event);
            });
        }
        return "Interview data-produced-successfully";
    }
}
