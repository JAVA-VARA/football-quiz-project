package com.example.footballquizproject.controller;

import com.example.footballquizproject.enumPack.EPLClubsSqudURL;
import com.example.footballquizproject.enumPack.LeagueClubsURL;
import com.example.footballquizproject.service.CollectPremierLeaguePlayers;
import com.example.footballquizproject.service.CollectTeamPremierLeague;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class WebCrawlingController {

    private final CollectPremierLeaguePlayers collectPremierLeaguePlayers;
    private final CollectTeamPremierLeague collectTeamPremierLeague;

    @GetMapping("/crawler/players")
    public void crawlingPlayersInfo() throws Exception {

        for(LeagueClubsURL L : LeagueClubsURL.values()){
            collectTeamPremierLeague.getTeamData(L);
        }

        for(EPLClubsSqudURL E : EPLClubsSqudURL.values()){
            collectPremierLeaguePlayers.PremierLeaguePlayersData(E);
        }
    }
}
