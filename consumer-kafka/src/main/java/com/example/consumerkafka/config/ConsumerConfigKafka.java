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
        // commit the offset value using consumer
        configPros.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,false);
        // if consumer reset(stop working) any reason and start again then
        // receiving the value from begning or start after previous offset
        // ("earliest" or "latest")
        configPros.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");
        configPros.put(ConsumerConfig.max,"earliest");
        return new DefaultKafkaConsumerFactory<>(configPros);
    }
}
