package ru.letton.practice_16.services;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.letton.practice_16.models.Game;
import ru.letton.practice_16.models.GameAuthor;
import ru.letton.practice_16.repositories.GameAuthorRepository;
import ru.letton.practice_16.repositories.GameRepository;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class FilterServiceTest {

    @Mock
    private GameRepository gameRepository;

    @Mock
    private GameAuthorRepository gameAuthorRepository;

    @InjectMocks
    private FilterService filterService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFilterGames() {
        String name = "TestGame";
        LocalDate creationDate = LocalDate.now();
        Integer authorId = 1;
        List<Game> expectedGames = Collections.singletonList(new Game());
        when(gameRepository.findAllByNameOrAuthor_IdOrCreationDate(name, authorId, creationDate)).thenReturn(expectedGames);
        List<Game> actualGames = filterService.filterGames(name, creationDate, authorId);
        assertEquals(expectedGames, actualGames);
        verify(gameRepository, times(1)).findAllByNameOrAuthor_IdOrCreationDate(name, authorId, creationDate);
    }

    @Test
    void testFilterGameAuthors() {
        String nickname = "TestAuthor";
        LocalDate birthDate = LocalDate.of(1990, 1, 1);
        List<GameAuthor> expectedAuthors = Collections.singletonList(new GameAuthor());
        when(gameAuthorRepository.findAllByNicknameOrBirthDate(nickname, birthDate)).thenReturn(expectedAuthors);
        List<GameAuthor> actualAuthors = filterService.filterGameAuthors(nickname, birthDate);
        assertEquals(expectedAuthors, actualAuthors);
        verify(gameAuthorRepository, times(1)).findAllByNicknameOrBirthDate(nickname, birthDate);
    }
}