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
    String firstName;

    @Column
    String middleName;

    @Column
    String lastName;

    @Column
    String backNumber;

    @Column
    String season;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private TeamCategory team;

    @Builder
    public Players(String imageUrl, String fullName, String lastName, String middleName , String firstName, String season, TeamCategory team, String backNumber){
        this.imageUrl = imageUrl;
        this.fullName = fullName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.firstName = firstName;
        this.season = season;
        this.backNumber = backNumber;
        this.team = team;
    }
}
