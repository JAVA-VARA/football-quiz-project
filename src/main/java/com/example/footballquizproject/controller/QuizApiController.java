package com.example.footballquizproject.controller;

import com.example.footballquizproject.dto.QuizDto;
import com.example.footballquizproject.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class QuizApiController {
    private final QuizService quizService;

    @GetMapping("/quiz")
    public String showQuiz(@RequestParam String teamName, Model model){
        List<QuizDto> quizList =  quizService.pick20PlayersByTeamName(teamName);
        model.addAttribute("quizListSet", quizList);

        return "quiz";
    }
}
