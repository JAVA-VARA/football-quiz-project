package com.example.footballquizproject.repository;

import com.example.footballquizproject.domain.Players;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayersRepository extends JpaRepository<Players, Long> {
    List<Players> findByTeamTeamName(String teamName);


}