package ru.mirea.practice_10;

import org.springframework.stereotype.Component;

@Component("trombonist")
public class Trombonist implements Musician {
    @Override
    public void doMusic() {
        System.out.println("Trombonist plays music.");
    }
}