package com.example.cloudstreamKafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;
import java.util.function.Function;

@SpringBootApplication
public class CloudstreamKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudstreamKafkaApplication.class, args);
	}
/*
Topics created by spring-boot autoconfigurable using method-name
topics name for producer.
 Input-chainal-Topic-name: (dataProducer-in-0)
 Output-chainal-Topic-name: (dataProducer-out-0)
 */
	@Bean
	public Function<String,String> dataProducer() {
		return data -> data;
	}


	/* Topics created by spring-boot autoconfigurable using method-name
	Processor-chanel-name
	Input-chainal-Topic-name: (dataProcessor-in-0)
	Output-chainal-Topic-name: (dataProcessor-out-0)
*/
@Bean
	public Function<String,String> dataProcessor() {
		return value -> value.toUpperCase();
	}

	/* Topics created by spring-boot autoconfigurable using method-name
	Consumer-chanel-name (Consumer can have only input-chainal)
	Input-chainal-Topic-name: (dataConsumer-in-0)
*/
@Bean
	public Consumer<String> dataConsumer() {
		return  val -> System.out.println("consumer-data {} "+val);
	}
}
