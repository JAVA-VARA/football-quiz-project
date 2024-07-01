package com.example.footballquizproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class QuizResultRequestDto {
    private Long quizId;
    private Long categoryId;
    private Long teamId;
    private int countCorrectAnswers;

    private List<String> userAnswers;
    private List<String> correctAnswers;
    private List<Boolean> isCorrectAnswers;
}
