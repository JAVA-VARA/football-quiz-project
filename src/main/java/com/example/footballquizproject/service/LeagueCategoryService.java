package com.example.footballquizproject.service;

import com.example.footballquizproject.domain.LeagueCategory;
import com.example.footballquizproject.dto.LeagueCategoryDto;
import com.example.footballquizproject.repository.LeagueCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LeagueCategoryService {

    private final LeagueCategoryRepository leagueCategoryRepository;

    public List<LeagueCategoryDto> getLeagueList() {
        List<LeagueCategory> leagueCategoryList = leagueCategoryRepository.findAll();

        List<LeagueCategoryDto> leagueList = new ArrayList<>();

        for(LeagueCategory leagueCategory: leagueCategoryList){
            LeagueCategoryDto leagueCategoryDto = new LeagueCategoryDto(leagueCategory.getLeague(), leagueCategory.getLeagueEmblem(), leagueCategory.getTeamList());
            leagueList.add(leagueCategoryDto);

        }
        return leagueList;
    }

}
