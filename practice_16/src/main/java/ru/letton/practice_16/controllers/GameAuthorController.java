package org.example.practice_15.controllers;

import org.example.practice_15.dao.GameAuthorDAO;
import org.example.practice_15.models.GameAuthor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class GameAuthorController {

    private final GameAuthorDAO gameAuthorDAO;

    @Autowired
    public GameAuthorController(GameAuthorDAO gameAuthorDAO) {
        this.gameAuthorDAO = gameAuthorDAO;
    }

    @PostMapping
    public void createGame(@RequestBody GameAuthor gameAuthor) {
        gameAuthorDAO.save(gameAuthor);
    }

    @DeleteMapping("/{index}")
    public void deleteGame(@PathVariable int index) {
        gameAuthorDAO.delete(index);
    }

    @GetMapping
    public List<GameAuthor> getAllGames() {
        return gameAuthorDAO.index();
    }
}