package com.example.footballquizproject.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class TeamCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teamId;

    @Column
    private String teamName;

    @Column
    private String teamEmblem;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Players> playersList;

    @ManyToOne
    @JoinColumn(name = "league")
    private LeagueCategory league;

    @Builder
    public TeamCategory(String teamName, String teamEmblem, LeagueCategory league){
        this.teamName = teamName;
        this.teamEmblem = teamEmblem;
        this.league =   league;
    }
}
