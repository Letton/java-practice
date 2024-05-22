package org.example.practice_12;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Practice12Application implements CommandLineRunner {

    private final FileProcessor fileProcessor;

    @Autowired
    public Practice12Application(FileProcessor fileProcessor) {
        this.fileProcessor = fileProcessor;
    }

    public static void main(String[] args) {
        SpringApplication.run(Practice12Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        fileProcessor.processFiles(args);
    }

}
