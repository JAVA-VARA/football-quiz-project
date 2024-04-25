package com.example.footballquizproject.controller;

import com.example.footballquizproject.dto.*;
import com.example.footballquizproject.service.LeagueCategoryService;
import com.example.footballquizproject.service.QuizService;
import com.example.footballquizproject.service.ResultService;
import com.example.footballquizproject.service.TeamCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
// Restful API
// resource => 자원
// GET /find-user-by-id
// GET users/:userId
//
// GET /find-boards-by-userid-pick-top10
// GET /users/:userId/boards?limit=10

@Controller()
@RequestMapping("/quizzes")
@RequiredArgsConstructor
public class QuizApiController {
    private final TeamCategoryService teamCategoryService;
    private final LeagueCategoryService leagueCategoryService;
    private final QuizService quizService;
    private final ResultService resultService;

    @GetMapping("/who-are-you")
    public String showTeamList(Model model){

        List<LeagueCategoryDto> league  = leagueCategoryService.getLeagueList();
        model.addAttribute("leagueCategories", league);

        List<TeamCategoryDto> teamCategories = teamCategoryService.getTeamCategoryList();
        model.addAttribute("teamCategories", teamCategories);

        return "teamCategory";
    }

    @GetMapping("/who-are-you/select-team")
    public String showQuiz(@RequestParam String teamName, Model model) {
        List<QuizDto> quizList = quizService.pick20PlayersByTeamName(teamName);

        model.addAttribute("quizListSet", quizList);
        model.addAttribute("team", teamName);
        return "quiz";
    }

    @PostMapping("/result")
    public String showResult(@RequestBody QuizResultRequestDto request, Model model) {

        int correctAnswers = request.getCorrectAnswers();
        String team = request.getTeam();

        resultService.saveQuizHistory(correctAnswers, team);
        String level = resultService.determineResult(correctAnswers);
        RankingDto rankingInfo = resultService.quizRankingByTeam(correctAnswers, team);

        model.addAttribute("correctAnswers", correctAnswers);
        model.addAttribute("level", level);
        model.addAttribute("team", team);

        model.addAttribute("ranking", rankingInfo);

        return "result";
    }
}
