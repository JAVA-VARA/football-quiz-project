package com.example.footballquizproject.controller;

import com.example.footballquizproject.domain.Players;
import com.example.footballquizproject.domain.TeamCategory;
import com.example.footballquizproject.service.CollectPremierLeaguePlayers;
import com.example.footballquizproject.service.CollectTeamPremierLeague;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class WebCrawlingController {

    private final CollectPremierLeaguePlayers collectPremierLeaguePlayers;
    private final CollectTeamPremierLeague collectTeamPremierLeague;

    @GetMapping("/crawler/players")
    public String crawlingPlayersInfo(Model model) throws Exception {

        List<TeamCategory> teamCategoryList = collectTeamPremierLeague.getTeamData();
        List<Players> players = collectPremierLeaguePlayers.PremierLeaguePlayersData();

        model.addAttribute("players", players);

        return "crawling-test";
    }

}
