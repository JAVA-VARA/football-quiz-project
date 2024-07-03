package com.example.footballquizproject.service;

import com.example.footballquizproject.domain.Players;
import com.example.footballquizproject.domain.TeamCategory;
import com.example.footballquizproject.enumPack.ClubsSquadURLProvider;
import com.example.footballquizproject.repository.PlayersRepository;
import com.example.footballquizproject.repository.TeamCategoryRepository;
import com.example.footballquizproject.util.WebDriverUtil;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CollectPlayersDataServiceImpl implements CollectPlayersDataService {
    private final PlayersRepository playersRepository;
    private final WebDriverUtil webDriverUtil;
    private final SavePlayersDataService savePlayersDataService;
    private final TeamCategoryRepository teamCategoryRepository;

    @Override
    public void collectPlayersData(ClubsSquadURLProvider squadURL) throws InterruptedException {
        WebDriver driver = webDriverUtil.connectingDriver(squadURL.getUrl());
        webDriverUtil.scrollDriver(driver);

        List<WebElement> elementsPlayersImage = driver.findElements(By.cssSelector(squadURL.getImageCssSelector()));
        List<WebElement> elementsPlayersName = driver.findElements(By.cssSelector(squadURL.getNameCssSelector()));
        List<WebElement> elementsSeason = driver.findElements(By.cssSelector(squadURL.getSeasonCssSelector()));
        List<WebElement> elementsPlayerBackNumber = driver.findElements(By.cssSelector(squadURL.getBackNumberCssSelector()));


        String teamName = squadURL.getTeam();
        TeamCategory team = teamCategoryRepository.findTeamCategoriesByTeamName(teamName);

        List<Players> playersInfoList = savePlayersDataService.savePlayersData(elementsPlayersImage, elementsPlayersName, elementsSeason, elementsPlayerBackNumber, team);

        driver.close();
        driver.quit();

        playersRepository.saveAll(playersInfoList);
    }
}

