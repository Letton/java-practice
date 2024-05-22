package org.example.practice_14.controllers;

import org.example.practice_14.models.Game;
import org.example.practice_14.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public List<Game> getAllGames() {
        return gameService.getAllGames();
    }

    @PostMapping
    public void addGame(@RequestBody Game game) {
        gameService.addGame(game);
    }

    @DeleteMapping("/{name}")
    public void deleteGame(@PathVariable String name) {
        gameService.deleteGame(name);
    }
}