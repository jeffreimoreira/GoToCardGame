package com.moreira.jeffrei.GoToCardGame.data.repository;

import com.moreira.jeffrei.GoToCardGame.data.model.Player;
import com.moreira.jeffrei.GoToCardGame.data.persistence.Datastore;
import com.moreira.jeffrei.GoToCardGame.service.LogService;
import org.springframework.stereotype.Repository;

/**
 * Created by jeffr on 2024-05-07
 */
@Repository
public class PlayerRepository extends BaseRepository<Player> {
    public PlayerRepository(Datastore datastore, LogService logService) {
        super(datastore, logService);
    }
}
