package com.moreira.jeffrei.GoToCardGame.data.persistence;

import com.moreira.jeffrei.GoToCardGame.data.model.BasePersistableEntity;

import java.util.Optional;

public interface Datastore {

    Optional<BasePersistableEntity> findById(Class<?> entityClass, Long id);
    BasePersistableEntity save(Class<?> entityClass, BasePersistableEntity entity);

    void delete(Class<?> entityClass, Long id);
}
