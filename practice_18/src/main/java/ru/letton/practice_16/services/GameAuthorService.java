package ru.letton.practice_16.services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.letton.practice_16.models.GameAuthor;
import ru.letton.practice_16.repositories.GameAuthorRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameAuthorService {
    public final GameAuthorRepository gameAuthorRepository;

    public void save(GameAuthor gameAuthor) {
        gameAuthorRepository.save(gameAuthor);
    }

    public void delete(Integer AuthorId) {
        gameAuthorRepository.deleteById(AuthorId);
    }

    public List<GameAuthor> getAll() {
        return gameAuthorRepository.findAll();
    }

}
