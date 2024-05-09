package com.moreira.jeffrei.GoToCardGame.data.persistence;

import com.moreira.jeffrei.GoToCardGame.data.model.BasePersistableEntity;

import java.util.Optional;
import java.util.Set;

public interface Datastore {

    Optional<BasePersistableEntity> findById(Class<?> entityClass, Long id);

    Set<BasePersistableEntity> findAll(Class<?> entityClass);
    BasePersistableEntity save(Class<?> entityClass, BasePersistableEntity entity);

    void delete(Class<?> entityClass, Long id);
}
