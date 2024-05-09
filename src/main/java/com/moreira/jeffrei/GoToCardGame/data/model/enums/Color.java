package com.moreira.jeffrei.GoToCardGame.data.model.enums;

public enum Color {

    HEARTS("hearts"),
    SPADES("spades"),
    CLUBS("clubs"),
    DIAMONDS("diamonds");

    private final String name;

    private Color(String name) {
        this.name = name;
    }

}
