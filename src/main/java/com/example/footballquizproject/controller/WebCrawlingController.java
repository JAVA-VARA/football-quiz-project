package com.example.footballquizproject.controller;

import com.example.footballquizproject.enumPack.ClubsSquadURLProvider;
import com.example.footballquizproject.enumPack.EPLClubsSquadURL;
import com.example.footballquizproject.enumPack.LaligaClubsSquadURL;
import com.example.footballquizproject.enumPack.LeagueClubsURL;
import com.example.footballquizproject.service.CollectPlayersDataService;
import com.example.footballquizproject.service.CollectTeamPremierLeague;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/crawler")
public class WebCrawlingController {

    private final CollectPlayersDataService collectPlayersData;
    private final CollectTeamPremierLeague collectTeamPremierLeague;


    @GetMapping("/players")
    public void crawlingPlayersInfo() throws Exception {
        collectPlayersByLeague(EPLClubsSquadURL.values());
        collectPlayersByLeagueLaliga(LaligaClubsSquadURL.values());
    }

    private void collectPlayersByLeague(ClubsSquadURLProvider[] squadURLs) throws Exception {
        for (ClubsSquadURLProvider squadURL : squadURLs) {
            collectPlayersData.collectPlayersData(squadURL);
        }
    }

    private void collectPlayersByLeagueLaliga(LaligaClubsSquadURL[] laligaClubsSquadURLs) throws Exception {
        for (LaligaClubsSquadURL squadURL : laligaClubsSquadURLs) {
            collectPlayersData.collectLaligaPlayersData(squadURL);
        }
    }



    @GetMapping("/team")
    public void crawlingTeamInfo() throws InterruptedException {
        for (LeagueClubsURL L : LeagueClubsURL.values()) {
            collectTeamPremierLeague.getTeamData(L);
        }
    }
}
