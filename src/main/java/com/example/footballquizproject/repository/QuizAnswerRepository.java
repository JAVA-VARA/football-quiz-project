package com.example.footballquizproject.repository;

import com.example.footballquizproject.domain.QuizAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizAnswerRepository extends JpaRepository<QuizAnswer, Long> {
}