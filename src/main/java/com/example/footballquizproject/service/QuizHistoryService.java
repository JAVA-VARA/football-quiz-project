package com.example.footballquizproject.service;

import com.example.footballquizproject.domain.*;
import com.example.footballquizproject.dto.QuizResultRequestDto;
import com.example.footballquizproject.repository.GameCategoryRepository;
import com.example.footballquizproject.repository.NewQuizHistoryRepository;
import com.example.footballquizproject.repository.QuizSetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizHistoryService {

    private final NewQuizHistoryRepository newQuizHistoryRepository;
    private final QuizSetRepository quizSetRepository;
    private final GameCategoryRepository gameCategoryRepository;
    private final QuizAnswerService quizAnswerService;

    @Transactional
    public void saveResult(QuizResultRequestDto quizResult) {

        List<QuizAnswer> quizAnswers = quizAnswerService.saveQuizAnswers(quizResult);

        QuizSet quizSet = quizSetRepository.findByQuizId(quizResult.getQuizId());
        TeamCategory team = quizSet.getTeamCategory();
        GameCategory quizCategory = gameCategoryRepository.findByCategoryId(quizResult.getCategoryId());

        boolean isCompleted = true;

        NewQuizHistory newQuizHistory = NewQuizHistory.builder()
                .isCompleted(isCompleted)
                .quizSet(quizSet)
                .quizAnswers(quizAnswers)
                .team(team)
                .game(quizCategory)
                .build();

        quizAnswers.forEach(quizAnswer -> quizAnswer.setQuizHistory(newQuizHistory));

        newQuizHistoryRepository.save(newQuizHistory);
    }
}