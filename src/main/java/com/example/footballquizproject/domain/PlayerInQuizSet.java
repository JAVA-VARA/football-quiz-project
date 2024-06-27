package com.example.footballquizproject.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class PlayerInQuizSet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long playerInQuizSetId;

    @ManyToOne
    @JoinColumn(name = "quiz_set_id")
    private QuizSet quizSet;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Players player;

    @Column
    private int orderIndex;


}