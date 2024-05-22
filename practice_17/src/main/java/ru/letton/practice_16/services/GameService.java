package ru.letton.practice_16.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.letton.practice_16.models.Game;
import ru.letton.practice_16.models.GameAuthor;
import ru.letton.practice_16.repositories.GameRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameService {
    private final GameRepository gameRepository;

    public void save(Game gameAuthor) {
        gameRepository.save(gameAuthor);
    }

    public void delete(Integer gameId) {
        gameRepository.deleteById(gameId);
    }

    public List<Game> getAll() {
        return gameRepository.findAll();
    }
}
