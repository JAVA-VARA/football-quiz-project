package com.example.footballquizproject.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Entity
@Getter
public class LeagueCategory {

    @Id
    private String league;

    @Column private String leagueEmblem;

    @OneToMany(mappedBy = "league",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TeamCategory> teamList;
}
