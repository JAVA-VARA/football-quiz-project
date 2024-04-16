package com.example.footballquizproject.controller;

import com.example.footballquizproject.dto.GameCategoryDto;
import com.example.footballquizproject.service.GameCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomePageViewController {

    private final GameCategoryService gameCategoryService;


    @GetMapping(value ={"/", "/quiz"})
    public String showQuizCategory(Model model){

        //나중에 게임이 많아지면 게임 검색 기능 추가

        List<GameCategoryDto> gameCategories = gameCategoryService.getGameCategoryList();
        model.addAttribute("categories", gameCategories);

        return "quizCategory";
    }
}
