package com.example.footballquizproject.dto;

import com.example.footballquizproject.domain.TeamCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class LeagueCategoryDto {
    private String league;
    private String leagueEmblem;
    private List<TeamCategory> teamList;
}
