package ru.letton.practice_16.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GameAuthorDTO {
    private int id;

    private String nickname;

    private LocalDate birthDate;

}
