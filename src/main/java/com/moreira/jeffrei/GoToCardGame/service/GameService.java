package com.moreira.jeffrei.GoToCardGame.service;

import com.moreira.jeffrei.GoToCardGame.data.repository.GameRepository;
import com.moreira.jeffrei.GoToCardGame.data.model.Card;
import com.moreira.jeffrei.GoToCardGame.data.model.Deck;
import com.moreira.jeffrei.GoToCardGame.data.model.Game;
import com.moreira.jeffrei.GoToCardGame.data.model.Player;
import com.moreira.jeffrei.GoToCardGame.data.model.enums.Color;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by jeffr on 2024-05-07
 */
@Service
public class GameService {

    private final GameRepository repository;
    private final DeckService deckService;
    private final PlayerService playerService;

    public GameService(GameRepository repository, DeckService deckService, PlayerService playerService) {
        this.repository = repository;
        this.deckService = deckService;
        this.playerService = playerService;
    }

    public Long createGame() {
        Game game = new Game();
        game = repository.save(game);
        return game.getId();
    }
    public void deleteGame(Long id) {
        repository.delete(Game.class, id);
    }

    public Game save(Game game) {
        return repository.save(game);
    }

    public void addDeck(Long id, Long deckId) {
        // this repetitive block of find plus return could be a function if we throw a meaningful exception instead of returning
        Game game = repository.findById(Game.class, id);
        if (game == null) {
            return; // could throw a meaningful exception
        }
        Deck deck = deckService.findById(deckId);
        if (deck == null) {
            return; // could throw a meaningful exception
        }

        if (deck.getInUse()) {
            // conflict - throw meaningful exception
        }
        deckService.addToGame(deck, id);
        game.addDeck(deck);
        game.shuffle();
        save(game);
    }

    public Long addPlayer(Long id, String name) {
        // this repetitive block of find plus return could be a function if we throw a meaningful exception instead of returning
        Game game = repository.findById(Game.class, id);
        if (game == null) {
            return null; // could throw a meaningful exception
        }
        Player player = playerService.createAndAddToGame(name, id);
        game.addPlayer(player);
        save(game);

        return player.getId();
    }

    public void removePlayer(Long id, Long playerId) {
        // this repetitive block of find plus return could be a function if we throw a meaningful exception instead of returning
        Game game = repository.findById(Game.class, id);
        if (game == null) {
            return; // could throw a meaningful exception
        }
        Player player = playerService.findById(playerId);
        game.removePlayer(player);
        save(game);
        playerService.deletePlayer(player);
    }

    public List<Card> dealNCardsToPlayer(Long id, Long playerId, Integer nbOfCards) {

        if (nbOfCards < 1) {
            return new ArrayList<>(); // could throw a meaningful exception
        }
        // this repetitive block of find plus return could be a function if we throw a meaningful exception instead of returning
        Game game = repository.findById(Game.class, id);
        if (game == null) {
            return new ArrayList<>(); // could throw a meaningful exception
        }

        Player player = playerService.findById(playerId);
        if (player == null) {
            return new ArrayList<>(); // could throw a meaningful exception
        }

        if (!playerIsInTheGame(game, player)) {
            return new ArrayList<>(); // could throw a meaningful exception
        }

        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < nbOfCards; i++) {
            Optional<Card> optionalCard = game.dealCard();
            if (optionalCard.isEmpty()) {
                break;
            }
            var card = optionalCard.get();
            player.addCard(card);
            cards.add(card);
        }

        return cards;

    }

    private boolean playerIsInTheGame(Game game, Player player) {
        return game.getPlayers().contains(player);
    }

    public List<Player> getAllPlayers(Long id) {
        // this repetitive block of find plus return could be a function if we throw a meaningful exception instead of returning
        Game game = repository.findById(Game.class, id);
        if (game == null) {
            return new ArrayList<>(); // could throw a meaningful exception
        }

        List<Player> players = new ArrayList<>(game.getPlayers());
        if (players.isEmpty()) {
            return new ArrayList<>();
        }

        players.sort((p1, p2) -> {
            return p2.getTotalValueOfCards() - p1.getTotalValueOfCards();
        });

        return players;
    }

    public Map<Color, Integer> getNbOfUndealtCardsPerColor(Long id) {

        // this repetitive block of find plus return could be a function if we throw a meaningful exception instead of returning
        Game game = repository.findById(Game.class, id);
        if (game == null) {
            return new HashMap<>(); // could throw a meaningful exception
        }

        var cards = game.getCards();
        if (cards.isEmpty()) {
            return new HashMap<>();
        }

        Map<Color, List<Card>> cardsByColor =
                cards.stream().collect(Collectors.groupingBy(Card::getColor));

        return cardsByColor.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().size()
                ));
    }
}
