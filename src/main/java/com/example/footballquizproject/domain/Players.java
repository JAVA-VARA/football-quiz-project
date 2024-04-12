package com.example.footballquizproject.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Players {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) String name;
    @Column(nullable = false) String imageUrl;

    @ManyToOne @JoinColumn(name = "team_name")
    private TeamCategory team;


}
