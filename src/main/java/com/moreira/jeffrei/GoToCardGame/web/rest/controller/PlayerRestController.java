package com.moreira.jeffrei.GoToCardGame.web.rest.controller;

import com.moreira.jeffrei.GoToCardGame.data.model.Card;
import com.moreira.jeffrei.GoToCardGame.service.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by jeffr on 2024-05-07
 */
@RestController
@RequestMapping("/api/v1/player")
public class PlayerRestController {

    private final PlayerService service;

    public PlayerRestController(PlayerService service) {
        this.service = service;
    }

    @GetMapping("/{id}/cards")
    public ResponseEntity<List<Card>> getCards(@PathVariable Long id) {
        List<Card> cards = service.getCards(id);

        return new ResponseEntity<>(cards, HttpStatus.CREATED);
    }
}
