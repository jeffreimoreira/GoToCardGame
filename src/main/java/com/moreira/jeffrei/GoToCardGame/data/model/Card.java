package com.moreira.jeffrei.GoToCardGame.data.model;

import com.moreira.jeffrei.GoToCardGame.data.model.enums.CardValue;
import com.moreira.jeffrei.GoToCardGame.data.model.enums.Color;

/**
 * Created by jeffr on 2024-05-06
 */
public class Card {

    private final CardValue value;
    private final Color color;

    public Card(CardValue value, Color color) {
        this.value = value;
        this.color = color;
    }

    public CardValue getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }
}
