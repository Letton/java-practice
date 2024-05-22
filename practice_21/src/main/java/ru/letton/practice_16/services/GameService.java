package ru.letton.practice_16.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.letton.practice_16.models.Game;
import ru.letton.practice_16.repositories.GameRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class GameService {
    private final GameRepository gameRepository;

    private final EmailService emailService;

    public void save(Game game) {
        emailService.sendEmail("lettonchannel@gmail.com", "Game saved", "Saved to " + game.toString());
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
