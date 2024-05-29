package ru.letton.practice_16.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.letton.practice_16.models.Game;
import ru.letton.practice_16.models.GameAuthor;
import ru.letton.practice_16.repositories.GameRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class GameServiceTest {

    @Mock
    private GameRepository gameRepository;

    @Mock
    private EmailService emailService;

    @InjectMocks
    private GameService gameService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveGame() {
        Game game = new Game();
        game.setId(1);
        game.setName("Test Game");
        game.setAuthor(new GameAuthor());
        gameService.save(game);
        verify(emailService, times(1)).sendEmail(anyString(), anyString(), anyString());
        verify(gameRepository, times(1)).save(game);
    }

    @Test
    public void testDeleteGame() {
        gameService.delete(1);
        verify(gameRepository, times(1)).deleteById(1);
    }

    @Test
    public void testGetAllGames() {
        List<Game> games = List.of(new Game(), new Game());
        when(gameRepository.findAll()).thenReturn(games);
        List<Game> result = gameService.getAll();
        assertEquals(2, result.size());
    }
}