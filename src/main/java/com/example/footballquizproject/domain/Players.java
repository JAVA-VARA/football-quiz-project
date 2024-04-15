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

    @Column(nullable = false) String imageUrl;
    @Column(nullable = false) String name;


    @ManyToOne @JoinColumn(name = "team_name")
    private TeamCategory team;

    @Builder
    public Players(String imageUrl, String name, TeamCategory team){
        this.imageUrl = imageUrl;
        this.name = name;
        this.team = team;
    }



}
