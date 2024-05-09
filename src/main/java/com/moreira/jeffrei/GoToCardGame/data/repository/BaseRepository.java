package com.moreira.jeffrei.GoToCardGame.data.repository;

import com.moreira.jeffrei.GoToCardGame.data.model.BasePersistableEntity;
import com.moreira.jeffrei.GoToCardGame.data.persistence.Datastore;

/**
 * Created by jeffr on 2024-05-07
 */

public abstract class BaseRepository<T extends BasePersistableEntity> {
    protected final Datastore datastore;

    public BaseRepository(Datastore datastore) {
        this.datastore = datastore;
    }

    public T save(T entity) {
        return (T) datastore.save(entity.getClass(), entity);
    }

    public void delete(T entity) {
        datastore.delete(entity.getClass(), entity.getId());
    }

    public void delete(Class<T> clazz, Long id) {
        datastore.delete(clazz, id);
    }

    public T findById(Class<T> clazz, Long id) {
        return (T) datastore.findById(clazz, id).orElse(null);
    }
}
