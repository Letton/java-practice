package ru.letton.practice_16.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.letton.practice_16.models.GameAuthor;

@Repository
public interface GameAuthorRepository extends JpaRepository<GameAuthor, Integer> {

}
