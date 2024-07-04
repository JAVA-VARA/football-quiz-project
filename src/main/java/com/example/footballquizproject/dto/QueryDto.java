package com.example.footballquizproject.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class QueryDto {
    private Long teamId;
    private String playerName;
    private String message;

    @Builder
    public QueryDto (Long teamId, String playerName, String message){
        this.teamId = teamId;
        this.playerName = playerName;
        this.message = message;

    }
}
