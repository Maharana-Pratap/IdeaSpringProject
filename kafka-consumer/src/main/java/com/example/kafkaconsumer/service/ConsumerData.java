package com.example.kafkaconsumer.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
@Slf4j
@Component
public class ConsumerData {

    @KafkaListener(topics = "emp-topic" , groupId = "emp-consumer-1")
    public void getValueFromEmpTopic(String obj) throws Exception {
        EmpEvent event = new ObjectMapper().readValue(obj,EmpEvent.class);
        Employee emp = event.getEmp();
        System.err.println("Emp-Consumer: "+emp);
        log.info("Emp-Consumer: "+emp);
        //return emp;
    }
}
