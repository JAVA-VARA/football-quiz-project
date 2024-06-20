package com.example.footballquizproject.repository;

import com.example.footballquizproject.domain.Players;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface PlayersRepository extends JpaRepository<Players, Long> {
    @Query(value = "SELECT * FROM players WHERE team_name = :teamName ORDER BY RAND() LIMIT 5", nativeQuery = true)
    List<Players> findRandomPlayersByTeamName(@Param("teamName") String teamName);

    @Query(value = "SELECT DISTINCT * FROM players WHERE team_id = :teamId ORDER BY RAND() LIMIT 10", nativeQuery = true)
    List<Players> findRandomPlayersByTeamIdPick10(Long teamId);

    @Query(value = "SELECT * FROM players WHERE team_id = :teamId ORDER BY RAND() LIMIT 20", nativeQuery = true)
    List<Players> findRandomPlayersByTeamIdPick20(Long teamId);
    @Query(value = "SELECT * FROM players WHERE team_id = :teamId", nativeQuery = true)
    Set<Players> findByTeamId(Long teamId);

}