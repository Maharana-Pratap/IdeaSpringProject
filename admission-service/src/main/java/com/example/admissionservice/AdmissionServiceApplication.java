package com.example.admissionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AdmissionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdmissionServiceApplication.class, args);
	}

}
