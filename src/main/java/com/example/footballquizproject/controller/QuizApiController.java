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

@Controller
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
    public String createQuizSet(@PathVariable("teamId")  Long teamId, Model model) {

        //몇문제 풀 것인지 선택할 수 있도록 할 예정(parameter로 받을 예정), 현재는 10문제 고정.
        List<QuizDto> quizSet  = quizService.createQuizSet(teamId, 10);

        QuizDto quizDto = quizSet.get(0);
        Long quizId = quizDto.getQuizId();

        model.addAttribute("quizListSet", quizSet);
        model.addAttribute("teamId", teamId);
        model.addAttribute("quizId", quizId);
        model.addAttribute("categoryId", 1L);

        return "new-quiz";
    }

    @PostMapping("/result")
    public String showResult(@RequestBody QuizResultRequestDto request, Model model) {

        resultService.saveResult(request);

        RankingDto rankingDto =  resultService.showResult(request);
        model.addAttribute("result", rankingDto);

        return "result";
    }
}
