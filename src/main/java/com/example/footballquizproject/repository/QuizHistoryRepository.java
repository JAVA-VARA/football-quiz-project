package com.example.footballquizproject.repository;

import com.example.footballquizproject.domain.QuizHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuizHistoryRepository extends JpaRepository<QuizHistory, Long> {
    @Query(value = "SELECT * FROM quiz_history WHERE team_id = :teamId ORDER BY correct_answer DESC", nativeQuery = true)
    List<QuizHistory> getRanking(Long teamId);

    @Query("SELECT q.teamId, COUNT(q) FROM QuizHistory q WHERE q.teamId IN :teamIds GROUP BY q.teamId")
    List<Object[]> getParticipantsCountByTeams(@Param("teamIds") List<Long> teamIds);

}