package com.example.footballquizproject.repository;

import com.example.footballquizproject.domain.LevelCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LevelCategoryRepository extends JpaRepository<LevelCategory, String> {
    LevelCategory findByMinCorrectAnswersLessThanEqualAndMaxCorrectAnswersGreaterThanEqual(int correctAnswers, int correctAnswers1);
}
