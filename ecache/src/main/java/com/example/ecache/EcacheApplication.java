package com.example.ecache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
//@EnableCaching
public class EcacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcacheApplication.class, args);
	}

}
