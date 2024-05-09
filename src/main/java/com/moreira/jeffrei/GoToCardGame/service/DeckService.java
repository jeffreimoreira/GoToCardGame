package com.moreira.jeffrei.GoToCardGame.service;

import com.moreira.jeffrei.GoToCardGame.data.repository.DeckRepository;
import com.moreira.jeffrei.GoToCardGame.data.model.Deck;
import org.springframework.stereotype.Service;

/**
 * Created by jeffr on 2024-05-07
 */
@Service
public class DeckService {

    private final DeckRepository repository;

    public DeckService(DeckRepository repository) {
        this.repository = repository;
    }

    public Deck createDeck() {
        Deck deck = Deck.getNewDeck();
        return repository.save(deck);
    }

    public Deck findById(Long id) {
        return repository.findById(Deck.class, id);
    }

    public Deck saveDeck(Deck deck) {
        return repository.save(deck);
    }

    public void addToGame(Deck deck, Long gameId) {
        if (deck == null || gameId == null) {
            // throw meaningful exception
            return;
        }
        deck.setGame(gameId);
        saveDeck(deck);
    }
}
