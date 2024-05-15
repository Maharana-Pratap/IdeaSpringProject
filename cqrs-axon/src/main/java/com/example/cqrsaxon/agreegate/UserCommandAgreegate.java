package com.example.cqrsaxon.agreegate;

import com.example.cqrsaxon.command.UserCommand;
import com.example.cqrsaxon.event.UserCreateEvent;
import lombok.Data;
import lombok.ToString;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
@Data
@ToString
public class UserCommandAgreegate {
    @AggregateIdentifier
    private Integer userId;
    private String userName;

    public UserCommandAgreegate(UserCommand command) {
        AggregateLifecycle.apply(new UserCreateEvent(command.getUserId(),
                command.getUserName(),
                command.getUserEmail()));
    }

    @EventSourcingHandler
    public void on(UserCreateEvent createEvent) {
        this.userId = createEvent.getUserId();
        this.userName = createEvent.getUserName();
    }
}
