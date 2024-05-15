package com.example.cqrsaxon.service;

import com.example.cqrsaxon.command.UserCommand;
import com.example.cqrsaxon.entity.User;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class UserService {

    @Autowired
    private CommandGateway commandGateway;

    //@Autowired
    //private UserRepository userRepository;
    
    public CompletableFuture<User> addUser(User user) {
         return commandGateway.send(new UserCommand(user.getUserId(),
                user.getUserName(),
                user.getUserEmail()));
        //return userRepository.save(user);
    }
}
