package com.moreira.jeffrei.GoToCardGame.logging;

import com.moreira.jeffrei.GoToCardGame.data.model.BasePersistableEntity;
import org.springframework.context.ApplicationEvent;

import java.time.LocalDateTime;

/**
 * Created by jeffr on 2024-05-08
 */
public class LogEvent extends ApplicationEvent {

    private final EventType eventType;
    private final Class<? extends BasePersistableEntity> entity;
    private final Long entityId;
    private final LocalDateTime dateTime;
    public LogEvent(Object source, EventType eventType, Class<? extends BasePersistableEntity> entity, Long entityId, LocalDateTime dateTime) {
        super(source);
        this.eventType = eventType;
        this.entityId = entityId;
        this.entity = entity;
        this.dateTime = dateTime;
    }

    public EventType getEventType() {
        return eventType;
    }

    public Class<? extends BasePersistableEntity> getEntity() {
        return entity;
    }

    public Long getEntityId() {
        return entityId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

}
