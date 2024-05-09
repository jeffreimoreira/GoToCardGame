package com.moreira.jeffrei.GoToCardGame.data.model;

import java.util.*;

/**
 * Created by jeffr on 2024-05-06
 */
public class Player extends BasePersistableEntity {

    private static Long sequence = 0L;

    private final String name;
    private final List<Card> cards = new ArrayList<>();

    private Long gameId;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Card> getCards() {
        return List.copyOf(cards);
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public Integer getTotalValueOfCards() {
        Integer total = 0;
        if (this.cards.isEmpty()) {
            return total;
        }
        return this.cards.stream().reduce(total, (partial, card) -> partial + card.getValue().getValue(), Integer::sum);
    }
    // TODO: add hash and equals
}
