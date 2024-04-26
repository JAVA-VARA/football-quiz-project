package com.example.footballquizproject.repository;

import com.example.footballquizproject.domain.Players;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlayersRepository extends JpaRepository<Players, Long> {
    @Query(value = "SELECT * FROM players WHERE team_name = :teamName ORDER BY RAND() LIMIT 5", nativeQuery = true)
    List<Players> findRandomPlayersByTeamName(@Param("teamName") String teamName);

    @Query(value = "SELECT * FROM players WHERE team_id = :teamId ORDER BY RAND() LIMIT 5", nativeQuery = true)
    List<Players> findRandomPlayersByTeamId(Long teamId);
}