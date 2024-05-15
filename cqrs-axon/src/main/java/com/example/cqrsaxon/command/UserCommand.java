package com.example.cqrsaxon.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCommand {
    @TargetAggregateIdentifier
    private Integer userId;
    private String userName;
    private String userEmail;
}
