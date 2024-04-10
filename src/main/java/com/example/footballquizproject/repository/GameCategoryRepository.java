package com.example.footballquizproject.repository;

import com.example.footballquizproject.domain.GameCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameCategoryRepository extends JpaRepository<GameCategory, Long> {
}
