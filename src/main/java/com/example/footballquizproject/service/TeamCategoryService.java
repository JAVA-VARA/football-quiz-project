package com.example.footballquizproject.service;

import com.example.footballquizproject.domain.TeamCategory;
import com.example.footballquizproject.dto.TeamCategoryDto;
import com.example.footballquizproject.repository.TeamCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamCategoryService {

    private final TeamCategoryRepository teamCategoryRepository;

    public List<TeamCategoryDto> getTeamCategoryList() {
        List<TeamCategory> teamCategoryList = teamCategoryRepository.findAll();

        List<TeamCategoryDto> teamCategories = new ArrayList<>();

        for(TeamCategory teamCategory: teamCategoryList){
            TeamCategoryDto teamCategoryDto = new TeamCategoryDto(teamCategory.getTeamName(), teamCategory.getTeamEmblem());
            teamCategories.add(teamCategoryDto);

        }
        return teamCategories;
    }
}
