package com.example.footballquizproject.repository;

import com.example.footballquizproject.domain.LeagueCategory;
import com.example.footballquizproject.domain.TeamCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TeamCategoryRepository extends JpaRepository<TeamCategory, String> {
    TeamCategory findTeamCategoriesByTeamName(String teamName);

    TeamCategory findByTeamId(Long teamId);

    List<TeamCategory> findTeamCategoriesByLeague(LeagueCategory league);
}
