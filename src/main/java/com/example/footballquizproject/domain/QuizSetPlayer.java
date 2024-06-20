package com.example.footballquizproject.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class QuizSetPlayer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "quiz_set_id", nullable = false)
    private QuizSet quizSet;

    @ManyToOne
    @JoinColumn(name = "player_id", nullable = false)
    private Players player;

    @Column
    private int orderIndex;


}