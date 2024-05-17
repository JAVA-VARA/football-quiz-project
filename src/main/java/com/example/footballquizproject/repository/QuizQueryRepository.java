package com.example.footballquizproject.repository;

import com.example.footballquizproject.domain.QuizQuery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizQueryRepository extends JpaRepository<QuizQuery, Long> {
}
