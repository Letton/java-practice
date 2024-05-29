package ru.letton.practice_16.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.letton.practice_16.dto.GameAuthorDTO;
import ru.letton.practice_16.dto.GameDTO;
import ru.letton.practice_16.models.Game;
import ru.letton.practice_16.models.GameAuthor;
import ru.letton.practice_16.repositories.GameAuthorRepository;
import ru.letton.practice_16.repositories.GameRepository;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
@ManagedResource(objectName = "ru.letton.practice_16:name=SchedulerService")
@Slf4j
@RequiredArgsConstructor
@Transactional
public class SchedulerService {

    private final GameRepository gameRepository;

    private final GameAuthorRepository gameAuthorRepository;

    private final ModelMapper modelMapper;

    private static final String DIRECTORY_PATH = "./data";

    @Scheduled(cron = "0 */30 * * * *")
    public void cleanDirectoryAndSaveData() {
        log.info("Scheduled task started: Cleaning directory and saving data");
        cleanDirectory();
        saveDataToFiles();
        log.info("Scheduled task completed: Directory cleaned and data saved");
    }

    @ManagedOperation(description = "Manually clean directory and save data")
    public void manualCleanDirectoryAndSaveData() {
        cleanDirectoryAndSaveData();
    }

    private void cleanDirectory() {
        File directory = new File(DIRECTORY_PATH);
        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (!file.delete()) {
                        log.warn("Failed to delete file: {}", file.getAbsolutePath());
                    }
                }
            }
        } else {
            directory.mkdirs();
        }
    }

    private void saveDataToFiles() {
        saveGamesToFile();
        saveGameAuthorsToFile();
    }

    public void saveGamesToFile() {
        List<Game> games = gameRepository.findAllWithAuthors();
        for (Game game : games) {
            log.info("Test {}", game.toString() + System.lineSeparator());
        }
        try (FileWriter writer = new FileWriter(DIRECTORY_PATH + "/games.txt")) {
            for (Game game : games) {
                writer.write(game.toString() + System.lineSeparator());
            }
        } catch (IOException e) {
            log.error("Error writing games to file", e);
        }
    }

    private void saveGameAuthorsToFile() {
        List<GameAuthor> authors = gameAuthorRepository.findAllWithGames();

        try (FileWriter writer = new FileWriter(DIRECTORY_PATH + "/authors.txt")) {
            for (GameAuthor author : authors) {
                writer.write(author.toString() + System.lineSeparator());
            }
        } catch (IOException e) {
            log.error("Error writing game authors to file", e);
        }
    }
}
