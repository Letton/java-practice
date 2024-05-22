package ru.letton.practice_16.services;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ru.letton.practice_16.models.Game;
import ru.letton.practice_16.models.GameAuthor;
import ru.letton.practice_16.repositories.GameAuthorRepository;
import ru.letton.practice_16.repositories.GameRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FilterService {

    public final GameRepository gameRepository;
    public final GameAuthorRepository gameAuthorRepository;

    public List<Game> filterGames(String name, LocalDate creationDate, Integer authorId) {
        return gameRepository.findAllByNameOrAuthor_IdOrCreationDate(name, authorId, creationDate);
    }

    public List<GameAuthor> filterGameAuthors(String nickname, LocalDate birthDate) {
        return gameAuthorRepository.findAllByNicknameOrBirthDate(nickname, birthDate);
    }
}
