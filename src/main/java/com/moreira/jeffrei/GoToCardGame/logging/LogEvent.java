package com.moreira.jeffrei.GoToCardGame.logging;

import org.springframework.context.ApplicationEvent;

import java.time.LocalDateTime;

/**
 * Created by jeffr on 2024-05-08
 */
public class LogEvent extends ApplicationEvent {


    private final EventType eventType;
    private final String entityName;
    private final Long entityId;
    private final LocalDateTime dateTime;
    public LogEvent(Object source, EventType eventType, String entityName, Long entityId, LocalDateTime dateTime) {
        super(source);
        this.eventType = eventType;
        this.entityId = entityId;
        this.entityName = entityName;
        this.dateTime = dateTime;
    }

    public EventType getEventType() {
        return eventType;
    }

    public String getEntityName() {
        return entityName;
    }

    public Long getEntityId() {
        return entityId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

}
