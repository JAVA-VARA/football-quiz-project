package com.example.footballquizproject.repository;

import com.example.footballquizproject.domain.QuizHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizHistoryRepository extends JpaRepository<QuizHistory, Long> {
    List<QuizHistory> findByTeam(String team);
}