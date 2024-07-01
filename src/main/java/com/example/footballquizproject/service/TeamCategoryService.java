package com.example.footballquizproject.service;

import com.example.footballquizproject.domain.LeagueCategory;
import com.example.footballquizproject.domain.TeamCategory;
import com.example.footballquizproject.dto.TeamCategoryDto;
import com.example.footballquizproject.repository.LeagueCategoryRepository;
import com.example.footballquizproject.repository.NewQuizHistoryRepository;
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
    private final NewQuizHistoryRepository newQuizHistoryRepository;

    public List<TeamCategoryDto> getTeamCategoryListByLeague(Long leagueId) {
        LeagueCategory league = leagueCategoryRepository.findLeagueCategoryByLeagueId(leagueId);
        List<TeamCategory> teamCategoryList = teamCategoryRepository.findTeamCategoriesByLeague(league);

        Map<Long, Long> participantsCountByTeams = getParticipantsCountByTeams(teamCategoryList);

        return teamCategoryList.stream()
                .map(teamCategory -> mapToDto(teamCategory, participantsCountByTeams))
                .collect(Collectors.toList());
    }


    private Map<Long, Long> getParticipantsCountByTeams(List<TeamCategory> teamCategoryList){
        return teamCategoryList.stream()
                .collect(Collectors.toMap(TeamCategory::getTeamId, this::getParticipantsCountByTeams));
    }

    private Long  getParticipantsCountByTeams(TeamCategory team){
        Long teamId = team.getTeamId();
        List<Object[]> results = newQuizHistoryRepository.findNewQuizHistoriesByTeamId(teamId);

        return results.isEmpty() ? 0L : (Long) results.get(0)[1];
    }

    private TeamCategoryDto mapToDto(TeamCategory team, Map<Long, Long> participantsCountByTeams) {

        Long teamId = team.getTeamId();

        return TeamCategoryDto.builder()
                .teamId(team.getTeamId())
                .teamName(team.getTeamName())
                .teamEmblem(team.getTeamEmblem())
                .numberOfParticipants(participantsCountByTeams.get(teamId))
                .build();
    }
}
