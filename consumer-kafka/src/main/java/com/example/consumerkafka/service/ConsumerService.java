package com.example.consumerkafka.service;

import com.example.consumerkafka.event.InterviewEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.retry.annotation.Backoff;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ConsumerService {

    List<Integer> invalidIdList = List.of(3, 5, 7, 9);

    @RetryableTopic(attempts = "3", backoff = @Backoff(delay = 2000, multiplier = 3))
    @KafkaListener(topics = "interview", groupId = "interview-consumers")
    public void getValueFromInterviewTopic(String event,
                                           @Header(KafkaHeaders.RECEIVED_TOPIC) String topicName,
                                           @Header(KafkaHeaders.OFFSET) long offset) throws JsonProcessingException {
        if (!event.isBlank()) {
            InterviewEvent data = new ObjectMapper().readValue(event, InterviewEvent.class);
                        if (invalidIdList.contains(data.getData().getId())) {
                            throw new RuntimeException("Invalid record found");
                        }
                    }
        };

    /**
     * Dead-Later-Topic handler method
     * which store missing record which is
     * not stored by consumer with any reason
     *
     * @param event
     */
    @DltHandler
    public void backupMissingData_DLT(String event, @Header(KafkaHeaders.RECEIVED_TOPIC) String topicName,
                                      @Header(KafkaHeaders.OFFSET) long offset) throws JsonProcessingException {

        InterviewEvent interview = new ObjectMapper().readValue(event, InterviewEvent.class);
        System.out.println("DTLData: " + interview.getData().getId() + ", " + topicName + ", " + offset);
    }

}


