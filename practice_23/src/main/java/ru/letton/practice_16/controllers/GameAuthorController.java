package ru.letton.practice_16.controllers;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.letton.practice_16.dto.GameAuthorDTO;
import ru.letton.practice_16.dto.GameDTO;
import ru.letton.practice_16.models.Game;
import ru.letton.practice_16.models.GameAuthor;
import ru.letton.practice_16.services.GameAuthorService;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
public class GameAuthorController {

    private final GameAuthorService gameAuthorService;

    private final ModelMapper modelMapper;

    @PostMapping
    public void createGameAuthor(@RequestBody GameAuthor gameAuthor) {
        gameAuthorService.save(gameAuthor);
    }

    @DeleteMapping("/{index}")
    public void deleteGameAuthor(@PathVariable int index) {
        gameAuthorService.delete(index);
    }

    @GetMapping
    public List<GameAuthorDTO> getAllGamesAuthors() {
        List<GameAuthor> gameAuthors = gameAuthorService.getAll();
        return gameAuthors.stream().map(this::convertGameAuthorToGameAuthorDTO).collect(Collectors.toList());
    }

    private GameAuthorDTO convertGameAuthorToGameAuthorDTO(GameAuthor gameAuthor) {
        return modelMapper.map(gameAuthor, GameAuthorDTO.class);
    }
}