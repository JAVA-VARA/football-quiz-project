package com.example.footballquizproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RankingDto {

    private int rank;
    private int totalParticipantsByTeam;


}
