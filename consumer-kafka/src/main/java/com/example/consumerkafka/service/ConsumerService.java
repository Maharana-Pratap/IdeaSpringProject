package com.example.consumerkafka.service;

import com.example.consumerkafka.event.InterviewEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.retry.annotation.Backoff;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
    }

    ;

    /**
     * Dead-Later-Topic handler method
     * which store missing record which is
     * not stored by consumer from any reason
     *
     * @param event
     */
    @DltHandler
    public void backupMissingData_DLT(String event, Acknowledgment acknowledgment,
                                      @Header(KafkaHeaders.RECEIVED_TOPIC) String topicName,
                                      @Header(KafkaHeaders.OFFSET) long offset,
                                      @Header(KafkaHeaders.RECEIVED_TIMESTAMP) long timestamp) throws JsonProcessingException {

        //==================== Starting fiter data specific date wise =============================
        // Define the target date for filtering
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String targetDate = "2024-11-20";  // Example target date

        LocalDateTime messageDate = new Timestamp(timestamp).toLocalDateTime();
        String messageDateStr = dateFormat.format(messageDate);

        if (messageDateStr.equals(targetDate)) {
            System.out.println("Received message for the target date: " + event);
        } else {
            System.out.println("Ignoring message from: " + messageDateStr);
        }
      //==================== End fiter data specific date wise =============================

        //=============== Manually commit the offset =============
        acknowledgment.acknowledge();
        //=====================================================
        InterviewEvent interview = new ObjectMapper().readValue(event, InterviewEvent.class);
        System.out.println("DTLData: " + interview.getData().getId() + ", " + topicName + ", " + offset);
    }
}


