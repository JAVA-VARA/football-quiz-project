package com.example.footballquizproject.repository;

import com.example.footballquizproject.domain.QuizSet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizSetRepository extends JpaRepository<QuizSet, Long> {

    QuizSet findByQuizSetId(Long quizSetId);

}
