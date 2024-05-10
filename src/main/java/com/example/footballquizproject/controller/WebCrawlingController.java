package com.example.footballquizproject.controller;

import com.example.footballquizproject.enumPack.*;
import com.example.footballquizproject.service.CollectPlayersDataService;
import com.example.footballquizproject.service.CollectTeamData;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/crawler")
public class WebCrawlingController {

    private final CollectPlayersDataService collectPlayersData;
    private final CollectTeamData collectTeamData;

    @Scheduled(cron = "0 0 0 07 09 ?" , zone = "Asia/Seoul")
    @GetMapping("/players")
    public void crawlingPlayersInfo() throws Exception {
        collectPlayersByLeague(EPLClubsSquadURL.values());
        collectPlayersByLeague(BundesLigaClubsSquadURL.values());
        collectPlayersByLeague(LaligaClubsSquadURL.values());
        collectPlayersByLeague(SerieAClubsSquadURL.values());
        collectPlayersByLeague(League1ClubsSquadURL.values());
    }

    @Scheduled(cron = "0 0 0 07 09 ?" , zone = "Asia/Seoul")
    @GetMapping("/team")
    public void crawlingTeamInfo() throws InterruptedException {
        for (LeagueClubsURL L : LeagueClubsURL.values()) {
            collectTeamData.collectTeamInfo(L);
        }
    }

    private void collectPlayersByLeague(ClubsSquadURLProvider[] squadURLs) throws Exception {
        for (ClubsSquadURLProvider squadURL : squadURLs) {
            collectPlayersData.collectPlayersData(squadURL);
        }
    }
}
