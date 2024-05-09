package com.moreira.jeffrei.GoToCardGame.logging;

public enum EventType {

    CREATED("created"),
    UPDATED("updated"),
    DELETED("deleted");

    private final String name;

    private EventType(String name) {
        this.name = name;
    }
}
