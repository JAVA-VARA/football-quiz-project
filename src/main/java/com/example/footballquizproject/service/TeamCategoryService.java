package com.example.footballquizproject.service;

import com.example.footballquizproject.domain.LeagueCategory;
import com.example.footballquizproject.domain.QuizHistory;
import com.example.footballquizproject.domain.TeamCategory;
import com.example.footballquizproject.dto.TeamCategoryDto;
import com.example.footballquizproject.repository.LeagueCategoryRepository;
import com.example.footballquizproject.repository.QuizHistoryRepository;
import com.example.footballquizproject.repository.TeamCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamCategoryService {

    private final TeamCategoryRepository teamCategoryRepository;
    private final LeagueCategoryRepository leagueCategoryRepository;
    private final QuizHistoryRepository quizHistoryRepository;

    public List<TeamCategoryDto> getTeamCategoryListByLeague(Long leagueId) {

        LeagueCategory league = leagueCategoryRepository.findLeagueCategoryByLeagueId(leagueId);
        List<TeamCategory> teamCategoryList = teamCategoryRepository.findTeamCategoriesByLeague(league);

        List<TeamCategoryDto> teamCategories = new ArrayList<>();

        for(TeamCategory teamCategory: teamCategoryList){
            TeamCategoryDto teamCategoryDto = new TeamCategoryDto(teamCategory.getTeamId(), teamCategory.getTeamName(), teamCategory.getTeamEmblem());
            teamCategories.add(teamCategoryDto);

            List<QuizHistory> quizHistories = quizHistoryRepository.getTotalParticipantsByTeam(teamCategory.getTeamId());
            teamCategoryDto.setGameParticipants(quizHistories.size());
        }
        return teamCategories;
    }
    public String getTeamName(Long teamId){
        TeamCategory teamCategory = teamCategoryRepository.findByTeamId(teamId);
        return teamCategory.getTeamName();
    }
}
