package com.moreira.jeffrei.GoToCardGame.logging;

import com.moreira.jeffrei.GoToCardGame.data.model.BasePersistableEntity;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Created by jeffr on 2024-05-09
 */
@Component
public class LogEventPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;

    public LogEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void publish(final EventType eventType, final BasePersistableEntity entity) {
        LogEvent event = new LogEvent(this, eventType, entity.getClass(), entity.getId(), LocalDateTime.now());
        applicationEventPublisher.publishEvent(event);
    }
}
