package com.example.footballquizproject.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TeamCategoryDto {

    private Long teamId;
    private String teamName;
    private String teamEmblem;
    private Long gameParticipants;

    public TeamCategoryDto(Long teamId, String teamName, String teamEmblem, Long orDefault) {
        this.teamEmblem = teamEmblem;
        this.teamName = teamName;
        this.teamId = teamId;
        this.gameParticipants = orDefault;
    }
}
