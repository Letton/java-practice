package org.example.practice_15.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "game_authors")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GameAuthor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "birth_date")
    private LocalDate birthDate;
}

