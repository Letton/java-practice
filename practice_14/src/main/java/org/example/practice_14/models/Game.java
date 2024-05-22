package org.example.practice_14.models;
import java.util.Date;

public class Game {
    private String name;
    private Date creationDate;

    public Game() {}

    public Game(String name, Date creationDate) {
        this.name = name;
        this.creationDate = creationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}