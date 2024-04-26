package com.example.footballquizproject.service;

import com.example.footballquizproject.domain.GameCategory;
import com.example.footballquizproject.dto.GameCategoryDto;
import com.example.footballquizproject.repository.GameCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GameCategoryService {
    private final GameCategoryRepository gameCategoryRepository;
    public List<GameCategoryDto> getGameCategoryList() {
        List<GameCategory> gameCategories = gameCategoryRepository.findAll();
        List<GameCategoryDto> gameCategoryDtoList = new ArrayList<>();

        for(GameCategory gameCategory : gameCategories){
            GameCategoryDto gameCategoryDto = new GameCategoryDto(gameCategory.getCategoryId(), gameCategory.getCategoryName(), gameCategory.getCategoryThumbnail(), gameCategory.getCategoryUrl());
            gameCategoryDtoList.add(gameCategoryDto);
        }

        return gameCategoryDtoList;
    }


}
