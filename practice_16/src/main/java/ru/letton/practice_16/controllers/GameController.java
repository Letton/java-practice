package org.example.practice_15.controllers;

import org.example.practice_15.dao.GameDAO;
import org.example.practice_15.models.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {

    private final GameDAO gameDAO;

    @Autowired
    public GameController(GameDAO gameDAO) {
        this.gameDAO = gameDAO;
    }

    @PostMapping
    public void createGame(@RequestBody Game game) {
        System.out.println(game);
        gameDAO.save(game);
    }

    @DeleteMapping("/{index}")
    public void deleteGame(@PathVariable int index) {
        gameDAO.delete(index);
    }

    @GetMapping
    public List<Game> getAllGames() {
        return gameDAO.index();
    }
}