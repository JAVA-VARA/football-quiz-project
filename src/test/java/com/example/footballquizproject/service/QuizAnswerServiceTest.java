package com.example.footballquizproject.service;

import com.example.footballquizproject.domain.QuizAnswer;
import com.example.footballquizproject.dto.QuizResultRequestDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class QuizAnswerServiceTest {

    @InjectMocks
    private QuizAnswerService quizAnswerService;

    @Test
    void saveQuizAnswersTest() {

        //given
        QuizResultRequestDto answerDto = QuizResultRequestDto.builder()
                .quizId(1L)
                .categoryId(1L)
                .teamId(1L)
                .countCorrectAnswers(5)
                .userAnswers(List.of("Answer1", "Answer2", "Answer3", "Answer4", "Answer5"))
                .correctAnswers(List.of("Correct1", "Correct2", "Correct3", "Correct4", "Correct5"))
                .isCorrectAnswers(List.of(true, false, true, false, true))
                .build();

        //when
        List<QuizAnswer> quizAnswers = quizAnswerService.saveQuizAnswers(answerDto);

        //then
        assertNotNull(quizAnswers);
        assertEquals(5,quizAnswers.size());
        assertEquals("Answer1", quizAnswers.get(0).getUserAnswer());
        assertEquals("Correct1", quizAnswers.get(0).getCorrectAnswer());
        assertTrue(quizAnswers.get(0).isCorrect());
    }
}