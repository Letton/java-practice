package org.example.practice_14.controllers;

import org.example.practice_14.models.GameAuthor;
import org.example.practice_14.services.GameAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/game-authors")
public class GameAuthorController {

    private final GameAuthorService gameAuthorService;

    public GameAuthorController(GameAuthorService gameAuthorService) {
        this.gameAuthorService = gameAuthorService;
    }

    @GetMapping
    public List<GameAuthor> getAllGameAuthors() {
        return gameAuthorService.getAllGameAuthors();
    }

    @PostMapping
    public void addGameAuthor(@RequestBody GameAuthor gameAuthor) {
        gameAuthorService.addGameAuthor(gameAuthor);
    }

    @DeleteMapping("/{nickname}")
    public void deleteGameAuthor(@PathVariable String nickname) {
        gameAuthorService.deleteGameAuthor(nickname);
    }
}