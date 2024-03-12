package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
@RestController
@RefreshScope
public class CloudConfigClientApplication {
    @Qualifier(value = "restTemp")
    @Autowired
    @Lazy
   private RestTemplate restTemplate;
    @Value("${server.url}")
    private String url;

    public static void main(String[] args) {
        SpringApplication.run(CloudConfigClientApplication.class, args);
    }

    @GetMapping("/get")
    public List<String> getValue() {
        System.out.println("url: "+url);
        return restTemplate.getForObject(url, List.class);
    }

    @Bean(name = "restTemp")
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
