package com.moreira.jeffrei.GoToCardGame.data.repository;

import com.moreira.jeffrei.GoToCardGame.data.model.LogEntry;
import com.moreira.jeffrei.GoToCardGame.data.persistence.Datastore;
import org.springframework.stereotype.Repository;

/**
 * Created by jeffr on 2024-05-07
 */
@Repository
public class LogRepository extends BaseRepository<LogEntry> {
    public LogRepository(Datastore datastore) {
        super(datastore, null);
    }
}
