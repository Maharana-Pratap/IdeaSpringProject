package com.example.demo.config;

import com.sun.source.tree.NewArrayTree;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class KafkaConfig {

    public NewTopic kafkaTopic() {
        return TopicBuilder.name("interview")
                .partitions(2)
                .replicas(2)
                .compact()
                .build();
    }

    @Bean
    public ProducerFactory<String, Object> producerFactoryObject() {
        Map<String, Object> configsProps = new HashMap<>();
        configsProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        configsProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        configsProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.springframework.kafka.support.serializer.JsonSerializer");
        // waiting of broaker/leader confirmation
        configsProps.put(ProducerConfig.ACKS_CONFIG, "all");
        // avoid duplicate value to produce by producer
        configsProps.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, true);
        //configsProps.put(JsonDeserializer.TRUSTED_PACKAGES, "com.example.kafkaproducer");

        return new DefaultKafkaProducerFactory<>(configsProps);
    }

    @Bean
    public ProducerFactory<String, String> producerFactoryString() {
        Map<String, Object> configsProps = new HashMap<>();
        configsProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        configsProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        configsProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
       // waiting of broaker/leader confirmation
        configsProps.put(ProducerConfig.ACKS_CONFIG, "all");
        // avoid duplicate value to produce by producer
        configsProps.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, true);
        return new DefaultKafkaProducerFactory<>(configsProps);
    }

    @Bean
    public KafkaTemplate<String, Object> kafkaTemplateObject() {
        return new KafkaTemplate<>(producerFactoryObject());
    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplateString() {
        return new KafkaTemplate<String, String>(producerFactoryString());
    }
}
