package com.example.consumerkafka.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class ConsumerConfigKafka {

    @Bean
    public ConsumerFactory<String, Object> kafkaConsumer() {
        Map<String,Object> configPros = new HashMap<>();
        configPros.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        configPros.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configPros.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        configPros.put(ConsumerConfig.GROUP_ID_CONFIG, "emp-consumer-1");
        configPros.put(JsonDeserializer.TRUSTED_PACKAGES, "com.example.consumerkafka");

        //============ Performance Optimization config =====================

        // commit the offset value using consumer enable/disabled
        configPros.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,false);
        // if consumer reset(stop working) any reason and start again then
        // receiving the value from begning or start after previous offset
        // ("earliest" or "latest")
        // [earliest]-> find value from begening every time
        // [latest]-> find value from next to commited offset
        configPros.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");
        // Wait until at least 1 KB of data is available
        configPros.put(ConsumerConfig.FETCH_MIN_BYTES_CONFIG,1024);
        // Set max fetch size to 10 MB (10485760)
        configPros.put(ConsumerConfig.FETCH_MAX_BYTES_CONFIG,1024*2);
        // Fetch up to 1000 records per poll
        configPros.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG,1000);
        // Set max poll interval to 10 minutes (in milliseconds)
        // Default Value: 300,000 ms (5 minutes)
        configPros.put(ConsumerConfig.MAX_POLL_INTERVAL_MS_CONFIG,600000);
        // Set session timeout to 60 seconds
        // Default Value: 45,000 ms (45 seconds)
        configPros.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG,60000);
        // // Set heartbeat interval to 5 seconds
        configPros.put(ConsumerConfig.HEARTBEAT_INTERVAL_MS_CONFIG,5000);

        return new DefaultKafkaConsumerFactory<>(configPros);
    }
}
