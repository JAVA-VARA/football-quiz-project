package com.example.footballquizproject.service;

import com.example.footballquizproject.domain.QuizQuery;
import com.example.footballquizproject.dto.QueryDto;
import com.example.footballquizproject.repository.QuizQueryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class QueryServiceTest {

    @Mock
    private QuizQueryRepository quizQueryRepository;

    @InjectMocks
    QueryService queryService;

    private QueryDto queryDto;

    @BeforeEach
    void setup(){
        //given
        queryDto = QueryDto.builder()
                .teamId(1L)
                .playerName("TEST_PLAYER")
                .message("TEST_MESSAGE")
                .build();
    }

    @Test
    void querySaveTest_success() {
        //when
        queryService.save(queryDto);

        //then
        verify(quizQueryRepository).save(any(QuizQuery.class));
    }

    @Test
    void querySaveTest_fail() {
        //given
        doThrow(new IllegalArgumentException("누락된 쿼리가 발생")).when(quizQueryRepository).save(any(QuizQuery.class));

        //when
        queryService.save(queryDto);

        //then
        verify(quizQueryRepository).save(any(QuizQuery.class));
    }
}