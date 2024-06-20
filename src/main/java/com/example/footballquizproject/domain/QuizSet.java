package com.example.footballquizproject.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class QuizSet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long quizSetId;

    @Column
    private Long teamId;

    @OneToMany(mappedBy = "quizSet", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<QuizSetPlayer> quizSetPlayers;

    @CreatedDate
    @Column
    private LocalDateTime createdAt;

}
