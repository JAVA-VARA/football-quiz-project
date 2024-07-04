package com.example.footballquizproject.service;

import com.example.footballquizproject.domain.QuizAnswer;
import com.example.footballquizproject.dto.QuizResultRequestDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizAnswerService {
    public List<QuizAnswer> saveQuizAnswers(QuizResultRequestDto answerDto) {

        List<String> correctAnswers = answerDto.getCorrectAnswers();
        List<String> userAnswers = answerDto.getUserAnswers();
        List<Boolean> isCorrect = answerDto.getIsCorrectAnswers();

        List<QuizAnswer> quizAnswers = new ArrayList<>();
        for(int i = 0; i < correctAnswers.size(); i++){
            QuizAnswer quizAnswer = QuizAnswer.builder()
                    .correctAnswer(correctAnswers.get(i))
                    .userAnswer(userAnswers.get(i))
                    .isCorrect(isCorrect.get(i))
                    .build();
            quizAnswers.add(quizAnswer);
        }

        return quizAnswers;
    }
}
