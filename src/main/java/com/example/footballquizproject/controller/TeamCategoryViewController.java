package com.example.footballquizproject.controller;

import com.example.footballquizproject.dto.LeagueCategoryDto;
import com.example.footballquizproject.dto.TeamCategoryDto;
import com.example.footballquizproject.service.LeagueCategoryService;
import com.example.footballquizproject.service.TeamCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TeamCategoryViewController {
    private final TeamCategoryService teamCategoryService;
    private final LeagueCategoryService leagueCategoryService;

    @GetMapping("/quiz/who-are-you")
    public String showTeamList(Model model){

        List<LeagueCategoryDto> league  = leagueCategoryService.getLeagueList();
        model.addAttribute("leagueCategories", league);

        List<TeamCategoryDto> teamCategories = teamCategoryService.getTeamCategoryList();
        model.addAttribute("teamCategories", teamCategories);

        return "teamCategory";
    }
}
