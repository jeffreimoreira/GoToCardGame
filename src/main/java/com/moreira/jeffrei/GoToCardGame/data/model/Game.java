package com.moreira.jeffrei.GoToCardGame.data.model;

import java.util.*;

/**
 * Created by jeffr on 2024-05-06
 */
public class Game extends BasePersistableEntity {

    private static Long sequence = 0L; // TODO remove

    private final List<Card> cards = new ArrayList<>();
    private final List<Player> players = new ArrayList<>();

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public List<Card> getCards() {
        return List.copyOf(cards);
    }

    public List<Player> getPlayers() {
        return List.copyOf(players);
    }

    public void addDeck(Deck deck) {
        if (deck == null) {
            return;
        }
        if (deck.getInUse()) {
            // TODO: throw exception - cannot use same deck twice in two different games
        }
        cards.addAll(deck.getCards());
    }

    public void addPlayer(Player player) {
        if (player == null) {
            return;
        }
        players.add(player);
    }

    public void removePlayer(Player player) {
        if (player == null) {
            return;
        }
        players.remove(player);
    }

    public Optional<Card> dealCard() {
        if (cards.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(cards.remove(0));
    }
// TODO: add hash and equals

}
