package com.example.footballquizproject.controller;

import com.example.footballquizproject.domain.Players;
import com.example.footballquizproject.service.WebCrawlingPlayersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class WebCrawlingController {

    private final WebCrawlingPlayersService webCrawlingPlayersService;
    @GetMapping("/crawler/players")
    public String crawlingPlayersInfo(Model model) throws IOException {

        List<Players> players = webCrawlingPlayersService.getPlayersInfo();
        model.addAttribute("players", players);

        return "crawling-test";
    }

}
