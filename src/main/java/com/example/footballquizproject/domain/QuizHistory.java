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

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime localDateTime;

    @Column
    private Long gameCategoryId;

    @Column
    private Long teamId;

    @Builder
    public QuizHistory(int correctAnswer, Long teamId){
        this.correctAnswer = correctAnswer;
        this.teamId = teamId;
    }
}
