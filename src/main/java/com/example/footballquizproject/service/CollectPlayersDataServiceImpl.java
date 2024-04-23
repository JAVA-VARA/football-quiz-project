package com.example.footballquizproject.service;

import com.example.footballquizproject.domain.Players;
import com.example.footballquizproject.enumPack.ClubsSquadURLProvider;
import com.example.footballquizproject.enumPack.League1ClubsSquadURL;
import com.example.footballquizproject.repository.PlayersRepository;
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

    @Override
    public void collectPlayersData(ClubsSquadURLProvider squadURL) throws InterruptedException {
        WebDriver driver = webDriverUtil.connectingDriver(squadURL.getUrl());
        webDriverUtil.scrollDriver(driver);

        List<WebElement> elementsPlayers = driver.findElements(By.cssSelector(squadURL.getImageCssSelector()));
        List<WebElement> elementsTeam = driver.findElements(By.cssSelector(squadURL.getNameCssSelector()));

        List<Players> playersInfoList = savePlayersDataService.savePlayersData(elementsPlayers, elementsTeam);

        driver.close();
        driver.quit();

        playersRepository.saveAll(playersInfoList);
    }

    @Override
    public void collectLeague1PlayersData(League1ClubsSquadURL league1ClubsSquadURL) throws InterruptedException {
        WebDriver driver = webDriverUtil.connectingDriver(league1ClubsSquadURL.getUrl());
        webDriverUtil.scrollDriver(driver);

        //팝업 없애는 로직 추가


        List<WebElement> elementsPlayers = driver.findElements(By.cssSelector(league1ClubsSquadURL.getImageCssSelector()));
        List<WebElement> elementsTeam = driver.findElements(By.cssSelector(league1ClubsSquadURL.getNameCssSelector()));

        List<Players> playersInfoList = savePlayersDataService.savePlayersData(elementsPlayers, elementsTeam);

        driver.close();
        driver.quit();

        playersRepository.saveAll(playersInfoList);

    }

//    public void collectPremierLeaguePlayersData(EPLClubsSquadURL epl) throws InterruptedException {
//
//        WebDriver driver = webDriverUtil.connectingDriver(epl.getUrl());
//        webDriverUtil.scrollDriver(driver);
//
//        List<WebElement> elementsPlayers = driver.findElements(By.cssSelector(epl. getImageCssSelector()));
//        List<WebElement> elementsTeam = driver.findElements(By.cssSelector(epl.getNameCssSelector()));
//
//        List<Players> playersInfoList = collectDataService.savePlayersData(elementsPlayers,elementsTeam);
//
//        driver.close();
//        driver.quit();
//
//        playersRepository.saveAll(playersInfoList);
//    }
//
//    public void collectLaligaPlayersData(LaligaClubsSquadURL laliga) throws InterruptedException {
//
//        WebDriver driver = webDriverUtil.connectingDriver(laliga.getUrl());
//        webDriverUtil.scrollDriver(driver);
//
//        List<WebElement> elementsPlayers = driver.findElements(By.cssSelector(laliga. getImageCssSelector()));
//        List<WebElement> elementsTeam = driver.findElements(By.cssSelector(laliga.getNameCssSelector()));
//
//        List<Players> playersInfoList = collectDataService.savePlayersData(elementsPlayers,elementsTeam);
//
//        driver.close();
//        driver.quit();
//
//        playersRepository.saveAll(playersInfoList);
//    }
//
//    public void collectLeague1PlayersData(League1ClubsSquadURL league1) throws InterruptedException {
//
//        WebDriver driver = webDriverUtil.connectingDriver(league1.getUrl());
//        webDriverUtil.scrollDriver(driver);
//
//        //팝업 삭제하는 로직 구현 필요함.
//
//        List<WebElement> elementsPlayers = driver.findElements(By.cssSelector(league1. getImageCssSelector()));
//        List<WebElement> elementsTeam = driver.findElements(By.cssSelector(league1.getNameCssSelector()));
//
//        List<Players> playersInfoList = collectDataService.savePlayersData(elementsPlayers,elementsTeam);
//
//        driver.close();
//        driver.quit();
//
//        playersRepository.saveAll(playersInfoList);
//    }
}
