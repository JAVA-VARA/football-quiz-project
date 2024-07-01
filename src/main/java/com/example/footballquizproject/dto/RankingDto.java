package com.example.footballquizproject.dto;

import com.example.footballquizproject.domain.LevelCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RankingDto {

    private int ranking;
    private int totalParticipantsByTeam;
    private LevelCategory level;
    private String teamName;
    private int correctAnswers;

}
