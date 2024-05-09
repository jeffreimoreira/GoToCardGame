package com.moreira.jeffrei.GoToCardGame.data.repository;

import com.moreira.jeffrei.GoToCardGame.data.model.Game;
import com.moreira.jeffrei.GoToCardGame.data.persistence.Datastore;
import com.moreira.jeffrei.GoToCardGame.service.LogService;
import org.springframework.stereotype.Repository;

/**
 * Created by jeffr on 2024-05-07
 */
@Repository
public class GameRepository extends BaseRepository<Game> {
    public GameRepository(Datastore datastore, LogService logService) {
        super(datastore, logService);
    }
}
