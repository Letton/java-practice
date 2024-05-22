package org.example.practice_14.dto;

import java.time.LocalDate;

public class GameAuthor {
    private String nickname;
    private LocalDate birthDate;

    public GameAuthor() {

    }

    public GameAuthor(String nickname, LocalDate birthDate) {
        this.nickname = nickname;
        this.birthDate = birthDate;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}