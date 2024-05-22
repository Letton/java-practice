package ru.letton.practice_16.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.letton.practice_16.models.Game;

public interface GameRepository extends JpaRepository<Game, Integer> {

}