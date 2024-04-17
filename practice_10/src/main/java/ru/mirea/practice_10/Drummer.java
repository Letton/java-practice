package ru.mirea.practice_10;

import org.springframework.stereotype.Component;

@Component("drummer")
public class Drummer implements Musician {
    @Override
    public void doMusic() {
        System.out.println("Drummer plays music.");
    }
}