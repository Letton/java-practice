package ru.letton.practice_16.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.letton.practice_16.models.GameAuthor;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GameDTO {
    private int id;

    private String name;

    private LocalDate creationDate;

    private GameAuthorDTO author;
}
