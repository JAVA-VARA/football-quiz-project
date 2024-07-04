package com.example.footballquizproject.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
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
