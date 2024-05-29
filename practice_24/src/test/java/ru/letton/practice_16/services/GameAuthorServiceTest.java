package ru.letton.practice_16.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.letton.practice_16.models.GameAuthor;
import ru.letton.practice_16.repositories.GameAuthorRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class GameAuthorServiceTest {

    @Mock
    private GameAuthorRepository gameAuthorRepository;

    @Mock
    private EmailService emailService;

    @InjectMocks
    private GameAuthorService gameAuthorService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveGameAuthor() {
        GameAuthor gameAuthor = new GameAuthor();
        gameAuthor.setId(1);
        gameAuthor.setNickname("Test Author");
        gameAuthorService.save(gameAuthor);
        verify(emailService, times(1)).sendEmail(anyString(), anyString(), anyString());
        verify(gameAuthorRepository, times(1)).save(gameAuthor);
    }

    @Test
    public void testDeleteGameAuthor() {
        gameAuthorService.delete(1);
        verify(gameAuthorRepository, times(1)).deleteById(1);
    }

    @Test
    public void testGetAllGameAuthors() {
        List<GameAuthor> gameAuthors = List.of(new GameAuthor(), new GameAuthor());
        when(gameAuthorRepository.findAll()).thenReturn(gameAuthors);
        List<GameAuthor> result = gameAuthorService.getAll();
        assertEquals(2, result.size());
    }
}