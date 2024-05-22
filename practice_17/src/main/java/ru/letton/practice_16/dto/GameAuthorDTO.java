package ru.letton.practice_16.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.letton.practice_16.models.Game;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GameAuthorDTO {
    private int id;

    private String nickname;

    private LocalDate birthDate;

}
