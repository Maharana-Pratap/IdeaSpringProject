package com.example.cqrsaxon.event;

import com.example.cqrsaxon.dao.UserRepository;
import com.example.cqrsaxon.entity.User;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserEventHandler {

    @Autowired
    private UserRepository userRepository;

    @EventHandler
    public void on(UserCreateEvent event) {
        userRepository.save(new User(event.getUserId(),
                event.getUserName(),
                event.getUserEmail()));
    }
}
