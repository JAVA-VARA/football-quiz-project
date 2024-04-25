package com.example.footballquizproject.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Players {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    String imageUrl;

    @Column(nullable = false)
    String fullname;

    @Column
    String firstname;

    @Column
    String lastname;

    @Column
    String middlename;

    @Column
    String season;

    @ManyToOne @JoinColumn(name = "team_name")
    private TeamCategory team;

    @Builder
    public Players(String imageUrl, String fullname, String lastname, String firstname, String season, TeamCategory team){
        this.imageUrl = imageUrl;
        this.fullname = fullname;
        this.lastname = lastname;
        this.firstname = firstname;
        this.season = season;
        this.team = team;
    }
}
