package ru.letton.practice_16.controllers;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.letton.practice_16.dto.GameAuthorDTO;
import ru.letton.practice_16.dto.GameDTO;
import ru.letton.practice_16.models.Game;
import ru.letton.practice_16.models.GameAuthor;
import ru.letton.practice_16.services.FilterService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class FilterController {

    private final FilterService filterService;

    private final ModelMapper modelMapper;

    @GetMapping("/games/filter")
    public List<GameDTO> filterGames(@RequestParam(required = false) String name,
                                  @RequestParam(required = false) LocalDate creationDate,
                                  @RequestParam(required = false) Integer authorId) {
        return filterService.filterGames(name, creationDate, authorId).stream().map(this::convertGameToGameDTO).collect(Collectors.toList());
    }

    @GetMapping("/authors/filter")
    public List<GameAuthorDTO> filterGameAuthors(@RequestParam(required = false) String nickname,
                                              @RequestParam(required = false) LocalDate birthDate) {
        return filterService.filterGameAuthors(nickname, birthDate).stream().map(this::convertGameAuthorToGameAuthorDTO).collect(Collectors.toList());
    }

    private GameAuthorDTO convertGameAuthorToGameAuthorDTO(GameAuthor gameAuthor) {
        return modelMapper.map(gameAuthor, GameAuthorDTO.class);
    }

    private GameDTO convertGameToGameDTO(Game game) {
        return modelMapper.map(game, GameDTO.class);
    }
}