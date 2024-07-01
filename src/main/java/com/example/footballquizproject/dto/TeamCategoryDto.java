package com.example.footballquizproject.dto;

import lombok.Builder;
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

    @Builder
    public TeamCategoryDto(Long teamId, String teamName, String teamEmblem, Long numberOfParticipants) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.teamEmblem = teamEmblem;
        this.gameParticipants = numberOfParticipants;
    }
}
