package com.moreira.jeffrei.GoToCardGame.data.model;

import com.moreira.jeffrei.GoToCardGame.logging.EventType;

import java.time.LocalDateTime;

/**
 * Created by jeffr on 2024-05-09
 */
public class LogEntry extends BasePersistableEntity {


    private EventType eventType;
    private Class<? extends BasePersistableEntity> entity;
    private Long entityId;
    private LocalDateTime dateTime;

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public Class<? extends BasePersistableEntity> getEntity() {
        return entity;
    }

    public void setEntity(Class<? extends BasePersistableEntity> entity) {
        this.entity = entity;
    }

    public Long getEntityId() {
        return entityId;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
