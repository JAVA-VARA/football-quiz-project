package com.example.footballquizproject.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class QuizSet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long quizId;

    @CreatedDate
    @Column
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private TeamCategory teamCategory;

    @OneToMany(mappedBy = "quizSet", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PlayerInQuizSet> playerInQuizSets;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "history_id")
    private NewQuizHistory newQuizHistory;


    public void addPlayerInQuizSet(PlayerInQuizSet playerInQuizSet) {

        if(playerInQuizSets == null){
            playerInQuizSets = new ArrayList<>();
        }

        playerInQuizSets.add(playerInQuizSet);

    }

}
