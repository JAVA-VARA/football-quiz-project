package com.example.footballquizproject.repository;

import com.example.footballquizproject.domain.QuizHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuizHistoryRepository extends JpaRepository<QuizHistory, Long> {
    @Query(value = "SELECT * FROM quiz_history WHERE team_id = :teamId ORDER BY correct_answer DESC", nativeQuery = true)
    List<QuizHistory> getRanking(Long teamId);

    @Query(value = "SELECT * FROM quiz_history WHERE team_id = :teamId", nativeQuery = true)
    List<QuizHistory> getTotalParticipantsByTeam(Long teamId);


}