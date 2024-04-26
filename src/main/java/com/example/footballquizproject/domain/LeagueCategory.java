package com.example.footballquizproject.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LeagueCategory {

    @Id
    private String league;

    @Column private String leagueEmblem;

    @OneToMany(mappedBy = "league",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TeamCategory> teamList = new ArrayList<>();

    @Builder
    public LeagueCategory(String league, String leagueEmblem){
        this.league = league;
        this.leagueEmblem = leagueEmblem;
    }

    public void mappingTeamToLeague(List<TeamCategory> teamList){
        this.teamList = teamList;
    }
}

