package com.example.footballquizproject.repository;

import com.example.footballquizproject.domain.TeamCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamCategoryRepository extends JpaRepository<TeamCategory, String> {
}
