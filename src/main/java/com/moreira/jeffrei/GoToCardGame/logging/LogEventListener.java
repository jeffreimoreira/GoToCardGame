package com.moreira.jeffrei.GoToCardGame.logging;

import com.moreira.jeffrei.GoToCardGame.data.model.LogEntry;
import com.moreira.jeffrei.GoToCardGame.service.LogService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Created by jeffr on 2024-05-08
 */
@Component
public class LogEventListener {

    private final LogService service;

    public LogEventListener(LogService service) {
        this.service = service;
    }

    @EventListener
    public void handleLogEvent(LogEvent event) {
        LogEntry logEntry = createLogEntryFromEvent(event);
        service.save(logEntry);
    }

    private LogEntry createLogEntryFromEvent(LogEvent event) {
        LogEntry entry = new LogEntry();
        entry.setEventType(event.getEventType());
        entry.setEntity(event.getEntity());
        entry.setEntityId(event.getEntityId());
        entry.setDateTime(event.getDateTime());

        return entry;
    }
}
