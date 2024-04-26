package com.example.footballquizproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GameCategoryDto {

    private Long id;
    private String categoryName;
    private String thumbnail;
    private String categoryUrl;


}
