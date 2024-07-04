package com.example.footballquizproject.service;

import com.example.footballquizproject.domain.LevelCategory;
import com.example.footballquizproject.repository.LevelCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LevelCategoryService {

    private final LevelCategoryRepository levelCategoryRepository;

    public LevelCategory getLevelByUserCorrectAnswers(int correctAnswers) {
        return levelCategoryRepository
                .findByMinCorrectAnswersLessThanEqualAndMaxCorrectAnswersGreaterThanEqual
                        (correctAnswers, correctAnswers);
    }
}
