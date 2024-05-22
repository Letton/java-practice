package ru.letton.practice_16.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.letton.practice_16.models.Game;

import java.time.LocalDate;
import java.util.List;

public interface GameRepository extends JpaRepository<Game, Integer> {
    List<Game> findAllByNameOrAuthor_IdOrCreationDate(String name, Integer authorId, LocalDate creationDate);
}