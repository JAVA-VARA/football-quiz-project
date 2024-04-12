package com.example.footballquizproject.service;

import com.example.footballquizproject.domain.AliasCategory;
import com.example.footballquizproject.repository.AliasCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ResultService {

    private final AliasCategoryRepository aliasCategoryRepository;
    public String determineResult(int correctAnswers) {
        // 정답 개수에 따라 결과를 반환
        AliasCategory alias =
                aliasCategoryRepository
                .findByMinCorrectAnswersLessThanEqualAndMaxCorrectAnswersGreaterThanEqual
                (correctAnswers,correctAnswers);

        return alias.getAlias();

    }
}
