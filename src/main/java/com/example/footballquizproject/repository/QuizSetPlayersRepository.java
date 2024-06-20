package com.example.footballquizproject.repository;

import com.example.footballquizproject.domain.QuizSetPlayer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizSetPlayersRepository extends JpaRepository<QuizSetPlayer, Long> {
}
