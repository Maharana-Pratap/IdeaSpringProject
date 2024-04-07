package com.example.profiledemo.config;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("cat")
public class Cat implements Animal {

    @Override
    public void show() {
        System.out.println("From cat");
    }
}
