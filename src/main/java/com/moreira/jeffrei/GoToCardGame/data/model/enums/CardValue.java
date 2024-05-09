package com.moreira.jeffrei.GoToCardGame.data.model.enums;

public enum CardValue {

    ACE("Ace", 1),
    TWO("2", 2),
    THREE("3", 3),
    FOUR("4", 4),
    FIVE("5", 5),
    SIX("6", 6),
    SEVEN("7", 7),
    EIGHT("8", 8),
    NINE("9", 9),
    TEN("10", 10),
    JACK("Jack", 11),
    QUEEN("Queen", 12),
    KING("King", 13);

    private final String symbol;
    private final int value;

    private CardValue(String symbol, int value) {
        this.symbol = symbol;
        this.value = value;
    }

    @Override
    public String toString() {
        return symbol;
    }

    public int getValue() {
        return value;
    }
}
