package com.example.footballquizproject.service;

import com.example.footballquizproject.domain.LeagueCategory;
import com.example.footballquizproject.domain.TeamCategory;
import com.example.footballquizproject.dto.TeamCategoryDto;
import com.example.footballquizproject.repository.LeagueCategoryRepository;
import com.example.footballquizproject.repository.QuizHistoryRepository;
import com.example.footballquizproject.repository.TeamCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeamCategoryService {

    private final TeamCategoryRepository teamCategoryRepository;
    private final LeagueCategoryRepository leagueCategoryRepository;
    private final QuizHistoryRepository quizHistoryRepository;

    public List<TeamCategoryDto> getTeamCategoryListByLeague(Long leagueId) {
        LeagueCategory league = leagueCategoryRepository.findLeagueCategoryByLeagueId(leagueId);
        List<TeamCategory> teamCategoryList = teamCategoryRepository.findTeamCategoriesByLeague(league);

        Map<Long, Long> participantsCountByTeams = quizHistoryRepository.getParticipantsCountByTeams(
                        teamCategoryList.stream().map(TeamCategory::getTeamId).collect(Collectors.toList()))
                .stream()
                .collect(Collectors.toMap(result -> (Long) result[0], result -> (Long) result[1]));

        return teamCategoryList.stream()
                .map(teamCategory -> new TeamCategoryDto(
                        teamCategory.getTeamId(),
                        teamCategory.getTeamName(),
                        teamCategory.getTeamEmblem(),
                        participantsCountByTeams.getOrDefault(teamCategory.getTeamId(), 0L)))
                .collect(Collectors.toList());
    }

    public String getTeamName(Long teamId){
        TeamCategory teamCategory = teamCategoryRepository.findByTeamId(teamId);
        return teamCategory.getTeamName();
    }
}
