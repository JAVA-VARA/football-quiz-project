package com.example.footballquizproject.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Players {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    String imageUrl;

    @Column(nullable = false)
    String fullName;

    @Column
    String firstname;

    @Column
    String lastname;

    @Column
    String backNumber;

    @Column
    String season;

    @ManyToOne @JoinColumn(name = "team_name")
    private TeamCategory team;

    @Builder
    public Players(String imageUrl, String fullName, String lastname, String firstname, String season, TeamCategory team, String backNumber){
        this.imageUrl = imageUrl;
        this.fullName = fullName;
        this.lastname = lastname;
        this.firstname = firstname;
        this.season = season;
        this.backNumber = backNumber;
        this.team = team;
    }
}
