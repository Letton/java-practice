package org.example.practice_14.services;

import org.example.practice_14.models.GameAuthor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameAuthorService {
    private final List<GameAuthor> gameAuthors = new ArrayList<>();

    public List<GameAuthor> getAllGameAuthors() {
        return gameAuthors;
    }

    public void addGameAuthor(GameAuthor gameAuthor) {
        gameAuthors.add(gameAuthor);
    }

    public void deleteGameAuthor(String nickname) {
        gameAuthors.removeIf(author -> author.getNickname().equals(nickname));
    }
}