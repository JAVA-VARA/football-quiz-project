package com.example.footballquizproject.service;

import com.example.footballquizproject.domain.Players;
import com.example.footballquizproject.domain.TeamCategory;
import com.example.footballquizproject.enumPack.EPLClubsSqudURL;
import com.example.footballquizproject.repository.PlayersRepository;
import com.example.footballquizproject.repository.TeamCategoryRepository;
import com.example.footballquizproject.util.WebDriverUtil;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CollectPremierLeaguePlayers  {

    private final TeamCategoryRepository teamCategoryRepository;
    private final PlayersRepository playersRepository;
    private final WebDriverUtil webDriverUtil;


    public void PremierLeaguePlayersData(EPLClubsSqudURL epl) throws InterruptedException {

        WebDriver driver = webDriverUtil.connectingDriver(epl.getUrl());
        webDriverUtil.scrollDriver(driver);

        List<WebElement> elementsPlayers = driver.findElements(By.cssSelector(epl.getImageCssSelector()));
        List<WebElement> elementsTeam = driver.findElements(By.cssSelector(epl.getNameCssSelector()));

        List<Players> playersInfoList = savePlayersData(elementsPlayers,elementsTeam);

        driver.close();
        driver.quit();

        playersRepository.saveAll(playersInfoList);
    }

    private List<Players> savePlayersData(List<WebElement> elementsPlayers, List<WebElement> elementsTeam){
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
