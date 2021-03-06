package com.interview.service1;

import com.interview.service1.command.GreetingCmd;
import com.interview.service1.event.GreetingEvt;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.commandhandling.model.AggregateLifecycle;
import org.axonframework.eventsourcing.EventSourcingHandler;

public class Handler {

    @AggregateIdentifier // (1)
    private String id;
    private int remainingValue;

    public Handler() {
        // (2)
    }

//    @CommandHandler // (3)
//    public Handler(GreetingCmd cmd) {
//        if(cmd.getAmount() <= 0) throw new IllegalArgumentException("amount <= 0");
//        AggregateLifecycle.apply(new GreetingEvt(cmd.getId())); // (4)
//    }
//
//    @EventSourcingHandler // (5)
//    public void on(IssuedEvt evt) {
//        id = evt.getId();
//        remainingValue = evt.getAmount();
//    }
//
//    @CommandHandler
//    public void handle(RedeemCmd cmd) {
//        if(cmd.getAmount() <= 0) throw new IllegalArgumentException("amount <= 0");
//        if(cmd.getAmount() > remainingValue) throw new IllegalStateException("amount > remaining value");
//        AggregateLifecycle.apply(new RedeemedEvt(id, cmd.getAmount()));
//    }
//
//    @EventSourcingHandler
//    public void on(RedeemedEvt evt) {
//        remainingValue -= evt.getAmount();
//    }
}