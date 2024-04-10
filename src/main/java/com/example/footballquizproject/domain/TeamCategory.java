package com.example.footballquizproject.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Getter
@Entity
public class TeamCategory {
    @Id private String teamName;

    @Column private String teamEmblem;
    @Column private String league;
    @Column private String leagueEmblem;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Players> playersList;


}
