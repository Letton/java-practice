package org.example.practice_14.models;

import java.time.LocalDate;
import java.util.Date;

public class GameAuthor {
    private String nickname;
    private Date birthDate;

    public GameAuthor(String nickname, Date birthDate) {
        this.nickname = nickname;
        this.birthDate = birthDate;
    }

    public GameAuthor() {}

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}