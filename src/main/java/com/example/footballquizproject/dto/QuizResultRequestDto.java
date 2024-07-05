package com.example.footballquizproject.dto;

import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class QuizResultRequestDto {
    private Long quizId;
    private Long categoryId;
    private Long teamId;
    private int countCorrectAnswers;

    private List<String> userAnswers;
    private List<String> correctAnswers;
    private List<Boolean> isCorrectAnswers;

    @Builder
    public QuizResultRequestDto(
            Long quizId, Long categoryId, Long teamId, int countCorrectAnswers,
            List<String> userAnswers, List<String> correctAnswers, List<Boolean> isCorrectAnswers){

        this.quizId = quizId;
        this.categoryId = categoryId;
        this.teamId = teamId;
        this.countCorrectAnswers = countCorrectAnswers;
        this.userAnswers = userAnswers;
        this.correctAnswers = correctAnswers;
        this.isCorrectAnswers = isCorrectAnswers;
    }
}
