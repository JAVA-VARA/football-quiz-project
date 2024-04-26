package com.example.footballquizproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class QuizResultRequestDto {
    private int correctAnswers;
    private Long teamId;
}
