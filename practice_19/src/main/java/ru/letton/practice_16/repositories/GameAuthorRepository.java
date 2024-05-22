package ru.letton.practice_16.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.letton.practice_16.models.Game;
import ru.letton.practice_16.models.GameAuthor;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface GameAuthorRepository extends JpaRepository<GameAuthor, Integer> {
    List<GameAuthor> findAllByNicknameOrBirthDate(String nickname, LocalDate birthDate);
}
