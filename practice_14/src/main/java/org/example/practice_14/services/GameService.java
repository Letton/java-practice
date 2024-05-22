package org.example.practice_14.services;

import org.example.practice_14.models.Game;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {
    private final List<Game> games = new ArrayList<>();

    public List<Game> getAllGames() {
        return games;
    }

    public void addGame(Game game) {
        games.add(game);
    }

    public void deleteGame(String name) {
        games.removeIf(game -> game.getName().equals(name));
    }
}