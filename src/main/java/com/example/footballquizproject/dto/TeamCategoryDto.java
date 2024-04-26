package com.example.footballquizproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TeamCategoryDto {

    private Long teamId;
    private String teamName;
    private String teamEmblem;
}
