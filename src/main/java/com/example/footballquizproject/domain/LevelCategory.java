package com.example.footballquizproject.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LevelCategory {

    @Id
    private String levels;

    @Column
    private int minCorrectAnswers;

    @Column
    private int maxCorrectAnswers;

    @Column
    private String levelImage;
}
