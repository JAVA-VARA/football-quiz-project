package com.example.footballquizproject.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class NewQuizHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long historyId;

    @Column
    private boolean isCompleted;

    @Column
    @CreatedDate
    private LocalDateTime endTime;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quiz_id")
    private QuizSet quizSet;

    @OneToMany(mappedBy = "quizHistory", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<QuizAnswer> quizAnswers;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private TeamCategory team;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private GameCategory game;

    @Builder
    public NewQuizHistory(boolean isCompleted, QuizSet quizSet, List<QuizAnswer> quizAnswers, TeamCategory team, GameCategory game) {
        this.isCompleted = isCompleted;
        this.quizSet = quizSet;
        this.quizAnswers = quizAnswers;
        this.team = team;
        this.game = game;
    }


    //TODO
//    @Column
//    private String deviceType;
//
//    @Column
//    private String userIpAddress;
//
//    @Column
//    private String userLocation;
//
//    @Column
//    private int attemptCount;

}
