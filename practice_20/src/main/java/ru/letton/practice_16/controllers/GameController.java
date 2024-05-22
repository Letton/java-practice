package ru.letton.practice_16.controllers;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.letton.practice_16.dto.GameAuthorDTO;
import ru.letton.practice_16.dto.GameDTO;
import ru.letton.practice_16.models.Game;
import ru.letton.practice_16.models.GameAuthor;
import ru.letton.practice_16.services.GameService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/games")
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

    private final ModelMapper modelMapper;

    @PostMapping
    public void createGame(@RequestBody Game game) {
        gameService.save(game);
    }

    @DeleteMapping("/{index}")
    public void deleteGame(@PathVariable int index) {
        gameService.delete(index);
    }

    @GetMapping
    public List<GameDTO> getAllGames() {
        List<Game> games = gameService.getAll();
        return games.stream().map(this::convertGameToGameDTO).collect(Collectors.toList());
    }

    private GameDTO convertGameToGameDTO(Game game) {
        return modelMapper.map(game, GameDTO.class);
    }
}