package com.example.footballquizproject.repository;

import com.example.footballquizproject.domain.NewQuizHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NewQuizHistoryRepository extends JpaRepository<NewQuizHistory, Long> {

    @Query(value = "SELECT qh.history_id, COUNT(CASE WHEN qa.is_correct = true THEN qa.quiz_answer_id END) as correct_answer_count " +
            "FROM new_quiz_history qh " +
            "LEFT JOIN quiz_answer qa ON qh.history_id = qa.history_id " +
            "WHERE qh.team_id = :teamId " +
            "GROUP BY qh.history_id ",
            nativeQuery = true)
    List<Object[]> findQuizHistoryWithCorrectAnswerCounts(@Param("teamId") Long teamId);
}