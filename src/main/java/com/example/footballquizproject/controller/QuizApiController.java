package com.example.footballquizproject.controller;

import com.example.footballquizproject.dto.*;
import com.example.footballquizproject.service.*;
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
    private final LeagueCategoryService leagueCategoryService;
    private final TeamCategoryService teamCategoryService;
    private final QuizService quizService;
    private final ResultService resultService;

    @GetMapping("/game-category/1")
    public String getLeagueList(Model model) {

        List<LeagueCategoryDto> leagueList = leagueCategoryService.getLeagueList();
        model.addAttribute("leagueList", leagueList);
        return "selectLeaguePage";
    }

    @GetMapping("/league-category/{leagueId}")
    public String showTeamList(@PathVariable("leagueId") Long leagueId, Model model) {

        List<TeamCategoryDto> teamList = teamCategoryService.getTeamCategoryListByLeague(leagueId);
        model.addAttribute("teamList", teamList);

        return "selectTeamPage";
    }


    @GetMapping("/team-category/{teamId}")
    public String showQuiz(@PathVariable("teamId")  Long teamId, Model model) {

        List<QuizDto> quizList = quizService.pick10PlayersByTeamId(teamId);

        model.addAttribute("quizListSet", quizList);
        model.addAttribute("teamId", teamId);
        return "quiz";
    }

    @PostMapping("/result")
    public String showResult(@RequestBody QuizResultRequestDto request, Model model) {

        int correctAnswers = request.getCorrectAnswers();
        Long teamId = request.getTeamId();
        String team =teamCategoryService.getTeamName(teamId);

        resultService.saveQuizHistory(correctAnswers, teamId);
        String level = resultService.determineResult(correctAnswers);
        RankingDto rankingInfo = resultService.quizRankingByTeam(correctAnswers, teamId);

        model.addAttribute("correctAnswers", correctAnswers);
        model.addAttribute("level", level);
        model.addAttribute("team", team);
        model.addAttribute("ranking", rankingInfo);

        return "result";
    }
}
