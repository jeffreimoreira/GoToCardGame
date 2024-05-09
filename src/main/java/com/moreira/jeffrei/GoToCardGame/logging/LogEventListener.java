package com.moreira.jeffrei.GoToCardGame.logging;

import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;

/**
 * Created by jeffr on 2024-05-08
 */
public class LogEventListener {

    @EventListener
    public void handleLogEvent(ContextStartedEvent cse) {
        System.out.println("Handling context started event.");
    }
}
