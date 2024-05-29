package ru.letton.practice_16.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.letton.practice_16.models.Game;

import java.time.LocalDate;
import java.util.List;

public interface GameRepository extends JpaRepository<Game, Integer> {

    @Query("SELECT g FROM Game g JOIN FETCH g.author")
    List<Game> findAllWithAuthors();

    List<Game> findAllByNameOrAuthor_IdOrCreationDate(String name, Integer authorId, LocalDate creationDate);
}