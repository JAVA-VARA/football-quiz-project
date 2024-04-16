package com.example.footballquizproject.controller;

import com.example.footballquizproject.dto.QuizDto;
import com.example.footballquizproject.dto.QuizResultRequestDto;
import com.example.footballquizproject.service.QuizService;
import com.example.footballquizproject.service.ResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class QuizApiController {
    private final QuizService quizService;
    private final ResultService resultService;

    @GetMapping("/quiz/who-are-you/select-team")
    public String showQuiz(@RequestParam String teamName, Model model){
        List<QuizDto> quizList =  quizService.pick20PlayersByTeamName(teamName);
        model.addAttribute("quizListSet", quizList);
        model.addAttribute("team", teamName);
        return "quiz";
    }

    @PostMapping("/quiz/result")
    public String showResult(@RequestBody QuizResultRequestDto request, Model model){

        int correctAnswers = request.getCorrectAnswers();
        String team = request.getTeam();

        resultService.saveQuizHistory(correctAnswers,  team);
        String level = resultService.determineResult(correctAnswers);
        int ranking = resultService.quizRankingByTeam(correctAnswers, team);

        model.addAttribute("correctAnswers", correctAnswers);
        model.addAttribute("level", level);
        model.addAttribute("ranking", ranking);

        return "result";
    }
}
