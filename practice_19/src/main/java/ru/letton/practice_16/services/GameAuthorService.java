package ru.letton.practice_16.services;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.letton.practice_16.models.GameAuthor;
import ru.letton.practice_16.repositories.GameAuthorRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class GameAuthorService {
    public final GameAuthorRepository gameAuthorRepository;

    public void save(GameAuthor gameAuthor) {
        log.info("save GameAuthor");
        gameAuthorRepository.save(gameAuthor);
    }

    public void delete(Integer AuthorId) {
        log.info("delete GameAuthor");
        gameAuthorRepository.deleteById(AuthorId);
    }

    public List<GameAuthor> getAll() {
        log.info("getAll GameAuthor");
        return gameAuthorRepository.findAll();
    }

}
