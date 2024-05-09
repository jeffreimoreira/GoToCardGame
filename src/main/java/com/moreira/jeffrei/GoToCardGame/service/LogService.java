package com.moreira.jeffrei.GoToCardGame.service;

import com.moreira.jeffrei.GoToCardGame.data.model.*;
import com.moreira.jeffrei.GoToCardGame.data.repository.LogRepository;
import com.moreira.jeffrei.GoToCardGame.logging.EventType;
import com.moreira.jeffrei.GoToCardGame.logging.LogEventPublisher;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by jeffr on 2024-05-09
 */
@Service
public class LogService {

    private final LogRepository repository;
    private final LogEventPublisher logEventPublisher;

    public LogService(LogRepository repository, LogEventPublisher logEventPublisher) {
        this.repository = repository;
        this.logEventPublisher = logEventPublisher;
    }

    public LogEntry save(LogEntry logEntry) {
        return repository.save(logEntry);
    }

    private Set<LogEntry> findAll() {
        return repository.findAll(LogEntry.class);
    }

    public List<LogEntry> getLogsForEntity(String entityName, Long id) {
        if (id == null || entityName == null || entityName.isBlank()) {
            throw new IllegalArgumentException("Invalid entity arguments");
        }

        final Map<String, Class<? extends BasePersistableEntity>> entityMap = Map.ofEntries(
                new AbstractMap.SimpleEntry<String, Class<? extends BasePersistableEntity>>("deck", Deck.class),
                new AbstractMap.SimpleEntry<String, Class<? extends BasePersistableEntity>>("player", Player.class),
                new AbstractMap.SimpleEntry<String, Class<? extends BasePersistableEntity>>("game", Game.class)
        );

        Class<? extends BasePersistableEntity> entityClass = entityMap.get(entityName);

        if (entityClass == null) {
            throw new IllegalArgumentException("Invalid entity arguments");
        }

        Set<LogEntry> entries = repository.findAll(LogEntry.class);

        if (entries.isEmpty()) {
            return new ArrayList<>();
        }

        return entries.stream()
                .filter(logEntry ->  entityClass.equals(logEntry.getEntity()) && id.equals(logEntry.getEntityId()))
                .sorted(Comparator.comparing(LogEntry::getDateTime)).collect(Collectors.toList());
    }

    public <T extends BasePersistableEntity> void logEvent(EventType eventType, T entity) {
        if (entity.getClass() == LogEntry.class) {
            return;
        }
        logEventPublisher.publish(eventType, entity);
    }
}
