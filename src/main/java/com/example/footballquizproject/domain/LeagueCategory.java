package com.example.footballquizproject.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class LeagueCategory {

    @Id
    private String league;

    @Column private String leagueEmblem;

    @OneToMany(mappedBy = "league",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TeamCategory> teamList;

    @Builder
    public LeagueCategory(String league, String leagueEmblem){
        this.league = league;
        this.leagueEmblem = leagueEmblem;
    }
}
