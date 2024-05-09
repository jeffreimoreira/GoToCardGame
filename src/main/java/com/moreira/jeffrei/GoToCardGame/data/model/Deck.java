package com.moreira.jeffrei.GoToCardGame.data.model;

import com.moreira.jeffrei.GoToCardGame.data.model.enums.CardValue;
import com.moreira.jeffrei.GoToCardGame.data.model.enums.Color;

import java.util.*;

/**
 * Created by jeffr on 2024-05-06
 */
public class Deck  extends BasePersistableEntity {

    private static Long sequence = 0L;

    public static Deck getNewDeck() {
        Deck deck = new Deck();  // TODO: move id to repository
        for (CardValue value : CardValue.values()) {
            for (Color color : Color.values())
                deck.cards.add(new Card(value, color));
        }
        return deck;
    }

    private final List<Card> cards = new ArrayList<>();


    private Long game;

    public Long getGame() {
        return game;
    }

    public void setGame(Long game) {
        this.game = game;
    }


    public Boolean getInUse() {
        return game != null;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public List<Card> getCards() {
        return List.copyOf(cards);
    }

    // TODO: add hash and equals
}
