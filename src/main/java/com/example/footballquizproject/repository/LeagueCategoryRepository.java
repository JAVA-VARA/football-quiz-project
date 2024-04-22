package com.example.footballquizproject.repository;

import com.example.footballquizproject.domain.LeagueCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeagueCategoryRepository extends JpaRepository<LeagueCategory, String> {
    LeagueCategory findLeagueCategoryByLeague(String league);
}