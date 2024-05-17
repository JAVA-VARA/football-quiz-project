package com.example.footballquizproject.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class QuizQuery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long teamId;

    @Column
    private String playerName;

    @Column
    private String message;

    public QuizQuery(Long teamId, String playerName, String message) {
        this.teamId = teamId;
        this.playerName = playerName;
        this.message = message;
    }
}
