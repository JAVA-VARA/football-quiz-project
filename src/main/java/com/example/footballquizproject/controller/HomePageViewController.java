package com.example.footballquizproject.controller;

import com.example.footballquizproject.domain.TeamCategory;
import com.example.footballquizproject.dto.GameCategoryDto;
import com.example.footballquizproject.dto.TeamCategoryDto;
import com.example.footballquizproject.service.GameCategoryService;
import com.example.footballquizproject.service.TeamCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomePageViewController {

    private final GameCategoryService gameCategoryService;
    private final TeamCategoryService teamCategoryService;

    @GetMapping("/home")
    public String showQuizCategory(Model model){

        List<GameCategoryDto> gameCategories = gameCategoryService.getGameCategoryList();
        model.addAttribute("categories", gameCategories);

        return "quizCategory";
    }

    @GetMapping("/selectTeam")
    public String showTeamList(Model model){

        List<TeamCategoryDto> teamCategories = teamCategoryService.getTeamCategoryList();
        model.addAttribute("teamCategories", teamCategories);
        return "teamCategory";
    }

}
