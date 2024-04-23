package com.example.footballquizproject.service;

import com.example.footballquizproject.domain.Players;
import com.example.footballquizproject.domain.TeamCategory;
import com.example.footballquizproject.repository.TeamCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SavePlayersDataService {

    private final TeamCategoryRepository teamCategoryRepository;
    List<Players> savePlayersData(List<WebElement> elementsPlayers, List<WebElement> elementsTeam){
        TeamCategory team = getTeamInfo(elementsTeam);

        List<Players> playersInfoList = new ArrayList<>();
        for (WebElement element : elementsPlayers) {

            String playerImage = element.getAttribute("src");
            String playerName = element.getAttribute("alt");

            Players player = Players.builder()
                    .imageUrl(playerImage) // 이미지 링크
                    .name(playerName)// 이름
                    .team(team)
                    .build();

            playersInfoList.add(player);
        }

        return playersInfoList;
    }

    private TeamCategory getTeamInfo(List<WebElement> elements){
        String teamName = elements.get(0).getText();
        return teamCategoryRepository.findTeamCategoriesByTeamName(teamName);
    }

}
