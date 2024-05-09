package com.moreira.jeffrei.GoToCardGame.data.model;

import java.util.Objects;

/**
 * Created by jeffr on 2024-05-07
 */
public abstract class BasePersistableEntity {

    private Long id;

    public BasePersistableEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BasePersistableEntity that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
