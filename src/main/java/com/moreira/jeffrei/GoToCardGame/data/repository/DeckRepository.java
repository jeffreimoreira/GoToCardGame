package com.moreira.jeffrei.GoToCardGame.data.repository;

import com.moreira.jeffrei.GoToCardGame.data.model.Deck;
import com.moreira.jeffrei.GoToCardGame.data.persistence.Datastore;
import org.springframework.stereotype.Repository;

/**
 * Created by jeffr on 2024-05-07
 */
@Repository
public class DeckRepository extends BaseRepository<Deck> {
    public DeckRepository(Datastore datastore) {
        super(datastore);
    }
}
