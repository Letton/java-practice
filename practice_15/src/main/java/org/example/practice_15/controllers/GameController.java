package org.example.practice_14.controllers;

import org.example.practice_14.Game;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {
    private final List<Game> games = new ArrayList<>();

    @PostMapping
    public void createGame(@RequestBody Game game) {
        games.add(game);
    }

    @DeleteMapping("/{index}")
    public void deleteGame(@PathVariable int index) {
        if (index >= 0 && index < games.size()) {
            games.remove(index);
        }
    }

    @GetMapping
    public List<Game> getAllGames() {
        System.out.println(games);
        return games;
    }
}