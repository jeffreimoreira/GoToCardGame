package com.moreira.jeffrei.GoToCardGame.service;

import com.moreira.jeffrei.GoToCardGame.data.repository.PlayerRepository;
import com.moreira.jeffrei.GoToCardGame.data.model.Card;
import com.moreira.jeffrei.GoToCardGame.data.model.Player;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jeffr on 2024-05-07
 */
@Service
public class PlayerService {

    private final PlayerRepository repository;

    private PlayerService(PlayerRepository repository) {
        this.repository = repository;
    }

    public Player save(Player player) {
        return repository.save(player);
    }

    public Player createAndAddToGame(String name, Long gameId) {
        Player player = new Player(name);
        player.setGameId(gameId);
        return save(player);
    }

    public Player findById(Long id) {
        return repository.findById(Player.class, id);
    }

    public void deletePlayer(Player player) {
        repository.delete(player);
    }

    public List<Card> getCards(Long id) {
        Player player = repository.findById(Player.class, id);
        if (player == null) {
            // could throw a meaningful exception
            return new ArrayList<>();
        }
        return player.getCards();
    }

    public Integer getTotalValueOfCards(Long id) {
        return getTotalValueOfCards(getCards(id));
    }

    public Integer getTotalValueOfCards(Player player) {
        return getTotalValueOfCards(player.getCards());
    }

    private Integer getTotalValueOfCards(List<Card> cards) {
        return cards.stream().reduce(0, (partial, card) -> partial + card.getValue().getValue(), Integer::sum);
    }

}
