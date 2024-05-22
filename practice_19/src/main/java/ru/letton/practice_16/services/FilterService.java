package ru.letton.practice_16.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.letton.practice_16.models.Game;
import ru.letton.practice_16.models.GameAuthor;
import ru.letton.practice_16.repositories.GameAuthorRepository;
import ru.letton.practice_16.repositories.GameRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class FilterService {

    public final GameRepository gameRepository;
    public final GameAuthorRepository gameAuthorRepository;

    public List<Game> filterGames(String name, LocalDate creationDate, Integer authorId) {
        log.info("Filter Game");
        return gameRepository.findAllByNameOrAuthor_IdOrCreationDate(name, authorId, creationDate);
    }

    public List<GameAuthor> filterGameAuthors(String nickname, LocalDate birthDate) {
        log.info("Filter GameAuthor");
        return gameAuthorRepository.findAllByNicknameOrBirthDate(nickname, birthDate);
    }
}
