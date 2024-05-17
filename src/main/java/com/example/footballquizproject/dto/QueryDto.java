package com.example.footballquizproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class QueryDto {
    private Long teamId;
    private String playerName;
    private String message;
}
