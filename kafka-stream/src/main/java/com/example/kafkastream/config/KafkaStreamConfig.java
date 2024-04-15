package com.example.kafkastream.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafkaStreams;

/**
 *  kafka stream config
 *
 */
@Configuration
@EnableKafkaStreams
public class KafkaStreamConfig {
    private static final Logger log = LoggerFactory.getLogger(KafkaStreamConfig.class);

}
