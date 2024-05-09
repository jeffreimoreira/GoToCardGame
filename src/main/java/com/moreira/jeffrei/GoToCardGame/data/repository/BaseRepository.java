package com.moreira.jeffrei.GoToCardGame.data.repository;

import com.moreira.jeffrei.GoToCardGame.data.model.BasePersistableEntity;
import com.moreira.jeffrei.GoToCardGame.data.persistence.Datastore;
import com.moreira.jeffrei.GoToCardGame.logging.EventType;
import com.moreira.jeffrei.GoToCardGame.service.LogService;
import org.springframework.lang.NonNull;

import java.util.Set;

/**
 * Created by jeffr on 2024-05-07
 */

public abstract class BaseRepository<T extends BasePersistableEntity> {
    private final Datastore datastore;
    private final LogService logService;

    public BaseRepository(@NonNull Datastore datastore, LogService logService) {
        this.datastore = datastore;
        this.logService = logService;
    }

    public T save(T entity) {
        EventType eventType = entity.getId() != null ? EventType.UPDATED : EventType.CREATED;
        entity = (T) datastore.save(entity.getClass(), entity);
        if (logService != null) {
            logService.logEvent(eventType, entity);
        }
        return entity;
    }

    public void delete(T entity) {
        datastore.delete(entity.getClass(), entity.getId());
        if (logService != null) {
            logService.logEvent(EventType.DELETED, entity);
        }
    }

    public void delete(Class<T> clazz, Long id) {
        datastore.delete(clazz, id);
    }

    public T findById(Class<T> clazz, Long id) {
        return (T) datastore.findById(clazz, id).orElse(null);
    }

    public Set<T> findAll(Class<T> clazz) {
        return (Set<T>) datastore.findAll(clazz);
    }
}
