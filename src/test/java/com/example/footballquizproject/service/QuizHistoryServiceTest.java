package com.example.footballquizproject.service;

import com.example.footballquizproject.domain.*;
import com.example.footballquizproject.dto.QuizResultRequestDto;
import com.example.footballquizproject.repository.GameCategoryRepository;
import com.example.footballquizproject.repository.NewQuizHistoryRepository;
import com.example.footballquizproject.repository.QuizSetRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class QuizHistoryServiceTest {

    @InjectMocks
    private QuizHistoryService quizHistoryService;

    @Mock
    private QuizAnswerService quizAnswerService;

    @Mock
    private NewQuizHistoryRepository newQuizHistoryRepository;
    @Mock
    private QuizSetRepository quizSetRepository;
    @Mock
    private GameCategoryRepository gameCategoryRepository;

    private QuizResultRequestDto requestDto;


    @BeforeEach
    void setup(){
        requestDto = QuizResultRequestDto.builder()
                .quizId(1L)
                .categoryId(1L)
                .teamId(1L)
                .countCorrectAnswers(5)
                .userAnswers(List.of("Answer1", "Answer2", "Answer3", "Answer4", "Answer5"))
                .correctAnswers(List.of("Correct1", "Correct2", "Correct3", "Correct4", "Correct5"))
                .isCorrectAnswers(List.of(true, false, true, false, true))
                .build();
    }

    @Test
    void saveResult() {
        //given
        List<QuizAnswer> quizAnswers = new ArrayList<>();
        when(quizAnswerService.saveQuizAnswers(requestDto)).thenReturn(quizAnswers);

        QuizSet quizSet = new QuizSet();
        when(quizSetRepository.findByQuizId(requestDto.getQuizId())).thenReturn(quizSet);
        quizSet.setTeamCategory(new TeamCategory());

        GameCategory gameCategory = new GameCategory();
        when(gameCategoryRepository.findByCategoryId(requestDto.getCategoryId())).thenReturn(gameCategory);

        //when
        quizHistoryService.saveResult(requestDto);

        //then
        verify(newQuizHistoryRepository, times(1)).save(any(NewQuizHistory.class));

    }
}