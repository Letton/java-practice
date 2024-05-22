package org.example.practice_12;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.security.MessageDigest;

@Component
public class FileProcessor {
    private Path sourcePath;


    @PostConstruct
    public void init() {
        System.out.println("FileProcessor init");
    }

    public void processFiles(String... args) {
        Path destinationPath;
        if (args.length >= 2) {
            sourcePath = Paths.get(args[0]);
            destinationPath = Paths.get(args[1]);
        } else {
            throw new IllegalArgumentException("Необходимо передать два аргумента: путь исходного файла и путь файла с хешем.");
        }

        try {
            if (Files.exists(sourcePath)) {
                byte[] data = Files.readAllBytes(sourcePath);
                byte[] hash = hashData(data);
                Files.write(destinationPath, hash);
            } else {
                Files.write(destinationPath, "null".getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private byte[] hashData(byte[] data) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        return digest.digest(data);
    }

    @PreDestroy
    public void cleanUp() throws Exception {
        if (Files.exists(sourcePath)) {
            Files.delete(sourcePath);
        }
        System.out.println("FileProcessor destroy");
    }
}
