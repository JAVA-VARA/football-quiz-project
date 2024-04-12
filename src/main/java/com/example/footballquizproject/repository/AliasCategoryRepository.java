package com.example.footballquizproject.repository;

import com.example.footballquizproject.domain.AliasCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AliasCategoryRepository extends JpaRepository<AliasCategory, String> {
    AliasCategory findByMinCorrectAnswersLessThanEqualAndMaxCorrectAnswersGreaterThanEqual(int correctAnswers, int correctAnswers1);
}
