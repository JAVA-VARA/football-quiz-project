package com.example.footballquizproject.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class QuizHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column private int correctAnswer;

    @Column(nullable = false, updatable = false)
    @CreatedDate
    private LocalDateTime localDateTime;

    @Column
    private String team;

    @Builder
    public QuizHistory(int correctAnswer, String team){
        this.correctAnswer = correctAnswer;
        this.team = team;
    }


}
