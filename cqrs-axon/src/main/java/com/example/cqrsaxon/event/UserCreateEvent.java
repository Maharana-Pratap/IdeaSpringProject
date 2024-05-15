package com.example.cqrsaxon.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserCreateEvent {
    private Integer userId;
    private String userName;
    private String userEmail;
}
