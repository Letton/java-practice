package ru.letton.practice_16.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "games")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "creation_date")
    private LocalDate creationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private GameAuthor author;

    @Override
    public String toString() {
        return "Game{id=" + id +
                ", name='" + name + '\'' +
                ", creationDate=" + creationDate +
                ", author=" + (author != null ? author.getNickname() : "null") + '}';
    }
}

