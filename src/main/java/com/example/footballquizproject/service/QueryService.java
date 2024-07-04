package com.example.footballquizproject.service;

import com.example.footballquizproject.domain.QuizQuery;
import com.example.footballquizproject.dto.QueryDto;
import com.example.footballquizproject.repository.QuizQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class QueryService {

    private final QuizQueryRepository quizQueryRepository;
    @Transactional
    public void save(QueryDto queryDto) {

        try {
            QuizQuery quizQuery = new QuizQuery(queryDto.getTeamId(), queryDto.getPlayerName(), queryDto.getMessage());
            quizQueryRepository.save(quizQuery);
        }
        catch (IllegalArgumentException e) {
            System.err.println("누락된 쿼리가 발생");
        }
    }
}
