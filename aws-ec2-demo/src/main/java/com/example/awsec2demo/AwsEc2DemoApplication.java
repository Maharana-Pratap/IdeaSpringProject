package com.example.awsec2demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/ec2")
public class AwsEc2DemoApplication {
@GetMapping("/")
	public String defMsg() {
		return "This is the first Spring-Boot ec2 instance api call!!!";
	}
	@GetMapping("/{msg}")
	public String messageParam(@PathVariable String msg) {
		return msg;
	}
	public static void main(String[] args) {
		SpringApplication.run(AwsEc2DemoApplication.class, args);
	}

}
