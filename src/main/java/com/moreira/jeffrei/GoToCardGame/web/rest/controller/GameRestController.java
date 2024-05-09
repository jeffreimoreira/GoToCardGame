package com.moreira.jeffrei.GoToCardGame.web.rest.controller;

import com.moreira.jeffrei.GoToCardGame.data.model.Card;
import com.moreira.jeffrei.GoToCardGame.data.model.Player;
import com.moreira.jeffrei.GoToCardGame.data.model.enums.Color;
import com.moreira.jeffrei.GoToCardGame.service.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by jeffr on 2024-05-07
 */
@RestController
@RequestMapping("/api/v1/game")
public class GameRestController {

    private final GameService service;

    public GameRestController(GameService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Long> createGame() {
        Long gameId = service.createGame();

        return new ResponseEntity<>(gameId, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGame(@PathVariable Long id) {
        service.deleteGame(id);

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{gameId}/decks")
    public ResponseEntity<Void> addDeck(@PathVariable Long gameId, @RequestBody Long deckId) {
        service.addDeck(gameId, deckId);

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{gameId}/players")
    public ResponseEntity<Long> addPlayer(@PathVariable Long gameId, @RequestBody String playerName) {
        Long playerId = service.addPlayer(gameId, playerName);

        return new ResponseEntity<>(playerId, HttpStatus.CREATED);
    }

    @DeleteMapping("/{gameId}/players/{playerId}")
    public ResponseEntity<Void> removePlayer(@PathVariable Long gameId, @PathVariable Long playerId) {
        service.removePlayer(gameId, playerId);

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{gameId}/players/{playerId}/deal")
    public ResponseEntity<List<Card>> dealCardsToPlayer(@PathVariable Long gameId,
                                                        @PathVariable Long playerId,
                                                        @RequestBody Integer nbOfCards) {
        List<Card> cards = service.dealNCardsToPlayer(gameId, playerId, nbOfCards);

        return new ResponseEntity<>(cards, HttpStatus.OK);
    }

    @GetMapping("/{gameId}/players")
    public ResponseEntity<List<Player>> getPlayers(@PathVariable Long gameId) {
        List<Player> players = service.getAllPlayers(gameId);

        return new ResponseEntity<>(players, HttpStatus.OK);
    }

    @GetMapping("/{gameId}/undealtCards")
    public ResponseEntity<Map<Color, Integer>> getNbOfUndealtCardsPerColor(@PathVariable Long gameId) {
        Map<Color, Integer> undealtCards = service.getNbOfUndealtCardsPerColor(gameId);

        return new ResponseEntity<>(undealtCards, HttpStatus.OK);
    }
}
