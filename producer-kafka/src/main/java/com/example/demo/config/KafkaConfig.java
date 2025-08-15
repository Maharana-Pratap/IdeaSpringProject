package com.example.demo.config;

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

    @Bean
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
        // maintain the order/sequence of message to produce by producer
        configsProps.put(ProducerConfig.MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION, 1);
        //configsProps.put(JsonDeserializer.TRUSTED_PACKAGES, "com.example.kafkaproducer");

        return new DefaultKafkaProducerFactory<>(configsProps);
    }

    @Bean
    public ProducerFactory<String, String> producerFactoryString() {
        Map<String, Object> configsProps = new HashMap<>();
        configsProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        configsProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        configsProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");

        //=============== Optimize performance config ===================

       // waiting of broaker/leader confirmation
        configsProps.put(ProducerConfig.ACKS_CONFIG, 1);
        // avoid duplicate value to produce by producer
        configsProps.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, true);
        // maintain the order/sequence of message to produce by producer
        configsProps.put(ProducerConfig.MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION, 1);
        // to delay sending messages in milliseconds, allowing batch formation
        configsProps.put(ProducerConfig.LINGER_MS_CONFIG,100);
        // Total memory the producer can use to buffer records.
        // Default: 32MB. You can increase based on system capacity
        configsProps.put(ProducerConfig.BUFFER_MEMORY_CONFIG,128);
        // Use compression to reduce payload size.
        //Options: snappy (balanced), lz4 (fastest), gzip (best compression)
        configsProps.put(ProducerConfig.COMPRESSION_TYPE_CONFIG,"lz4");
        // Increases the number of records sent in a single request.
        // A higher value improves throughput. Here (32768)=32KB.
        configsProps.put(ProducerConfig.BATCH_SIZE_CONFIG,32768*2);
        // Number of retry attempts
        configsProps.put(ProducerConfig.RETRIES_CONFIG,5);
        // Wait 1 second before retrying
        configsProps.put(ProducerConfig.RETRY_BACKOFF_MS_CONFIG,1000);
        
        return new DefaultKafkaProducerFactory<>(configsProps);
    }

    @Bean
    public KafkaTemplate<String, Object> kafkaTemplateObject() {
        return new KafkaTemplate<>(producerFactoryObject());
    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplateString() {
        return new KafkaTemplate<>(producerFactoryString());
    }
}
