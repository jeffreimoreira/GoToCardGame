package com.moreira.jeffrei.GoToCardGame.data.persistence;

import com.moreira.jeffrei.GoToCardGame.data.model.BasePersistableEntity;
import com.moreira.jeffrei.GoToCardGame.data.model.Deck;
import com.moreira.jeffrei.GoToCardGame.data.model.Game;
import com.moreira.jeffrei.GoToCardGame.data.model.Player;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created by jeffr on 2024-05-07
 */
@Component
public class InMemoryDatastore implements Datastore{

    private static final Object lock = new Object();
    private static final Map<String, Map<Long, BasePersistableEntity>> dataset;


    private static final Map<String, Long> sequences;
    private static final Map<Class<?>, String> entityNames;

    static {
        dataset = new HashMap<>();
        entityNames = new HashMap<>();
        sequences = new HashMap<>();

        entityNames.put(Deck.class, "deck");
        entityNames.put(Game.class, "game");
        entityNames.put(Player.class, "player");

        for (String entityName : entityNames.values()) {
            dataset.put(entityName, new HashMap<>());
            sequences.put(entityName, 0L);
        }
    }


    @Override
    public Optional<BasePersistableEntity> findById(Class<?> entityClass, Long id) {

        if (id == null) {
            //bad arguments - could throw a meaningful exception
            return Optional.empty();
        }
        String entityName = getEntityName(entityClass);

        synchronized(dataset) {
            var entries = Map.copyOf(dataset.get(entityName));
            return Optional.ofNullable(entries.get(id)); // could check throw an not found exception instead of returning null
        }
    }

    @Override
    public BasePersistableEntity save(Class<?> entityClass, BasePersistableEntity entity) {

        if (entity == null) {
            //bad arguments - could throw a meaningful exception
            return null;
        }
        String entityName = getEntityName(entityClass);

        synchronized(dataset) {
            if (entity.getId() == null) {
                entity.setId(getNextId(entityName));
            }
            var entries = dataset.get(entityName);
            entries.put(entity.getId(), entity);
        }

        return entity;
    }

    private Long getNextId(String entityName) {
        Long nextId = sequences.get(entityName) + 1;
        sequences.put(entityName, nextId);
        return nextId;
    }

    private String getEntityName(Class<?> entityClass) {
        if (entityClass == null) {
            //bad arguments - could throw a custom, meaningful, checked exception
            throw new IllegalArgumentException();
        }
        String entityName = entityNames.get(entityClass);
        if (entityName == null) {
            // unsupported class - could throw a custom, meaningful, checked exception
            throw new UnsupportedOperationException();
        }
        return entityName;
    }

    @Override
    public void delete(Class<?> entityClass, Long id) {


        if (id == null) {
            //bad arguments - could throw a meaningful exception
            return;
        }
        String entityName = getEntityName(entityClass);


        synchronized(dataset) {
            var entries = dataset.get(entityName);
            entries.remove(id); // could check the return value to validate/inform if something was indeed removed
        }
    }
}
