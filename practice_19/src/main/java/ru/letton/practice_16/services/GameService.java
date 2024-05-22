package ru.letton.practice_16.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.letton.practice_16.models.Game;
import ru.letton.practice_16.models.GameAuthor;
import ru.letton.practice_16.repositories.GameRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class GameService {
    private final GameRepository gameRepository;

    public void save(Game game) {
        log.info("save Game");
        gameRepository.save(game);
    }

    public void delete(Integer gameId) {
        log.info("delete Game");
        gameRepository.deleteById(gameId);
    }

    public List<Game> getAll() {
        log.info("getAll Game");
        return gameRepository.findAll();
    }
}
