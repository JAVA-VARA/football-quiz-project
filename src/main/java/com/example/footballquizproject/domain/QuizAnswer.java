package com.example.footballquizproject.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class QuizAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long quizAnswerId;

    @Column
    private String correctAnswer;

    @Column
    private String userAnswer;

    @Column
    private boolean isCorrect;

    @ManyToOne
    @JoinColumn(name = "history_id")
    private NewQuizHistory quizHistory;
}
