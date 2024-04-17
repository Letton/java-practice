package ru.mirea.practice_10;

import org.springframework.stereotype.Component;

@Component("guitarist")
public class Guitarist implements Musician {
    @Override
    public void doMusic() {
        System.out.println("Guitarist plays music.");
    }
}