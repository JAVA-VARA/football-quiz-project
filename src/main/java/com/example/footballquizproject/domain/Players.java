package com.example.footballquizproject.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Players {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @Column(nullable = false)
    String imageUrl;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Players players = (Players) o;
        return Objects.equals(fullName, players.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName);
    }
}
