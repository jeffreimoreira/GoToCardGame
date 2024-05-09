package com.moreira.jeffrei.GoToCardGame.web.rest.controller;

import com.moreira.jeffrei.GoToCardGame.service.DeckService;
import com.moreira.jeffrei.GoToCardGame.data.model.Deck;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jeffr on 2024-05-07
 */
@RestController
@RequestMapping("/api/v1/deck")
public class DeckRestController {

    private final DeckService service;

    public DeckRestController(DeckService service) {
        this.service = service;
    }

    @PostMapping("")
    public ResponseEntity<Deck> createDeck() {
        Deck deck = service.createDeck();

        return new ResponseEntity<>(deck, HttpStatus.CREATED);
    }
}
