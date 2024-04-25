package com.example.footballquizproject.service;

import com.example.footballquizproject.domain.Players;
import com.example.footballquizproject.domain.TeamCategory;
import com.example.footballquizproject.enumPack.ClubsSquadURLProvider;
import com.example.footballquizproject.enumPack.LaligaClubsSquadURL;
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
        List<WebElement>elementsPlayersName = driver.findElements(By.cssSelector(squadURL.getNameCssSelector()));
        List<WebElement> elementsTeam = driver.findElements(By.cssSelector(squadURL.getTeamCssSelector()));

        String teamName = elementsTeam.get(0).getText();
        TeamCategory team = teamCategoryRepository.findTeamCategoriesByTeamName(teamName);

        List<Players> playersInfoList = savePlayersDataService.savePlayersData(elementsPlayersImage,elementsPlayersName,team);

        driver.close();
        driver.quit();

        playersRepository.saveAll(playersInfoList);
    }

    @Override
    public void collectLaligaPlayersData(LaligaClubsSquadURL laligaClubsSquadURL) throws InterruptedException{
        WebDriver driver = webDriverUtil.connectingDriver(laligaClubsSquadURL.getUrl());
//        webDriverUtil.scrollDriver(driver);
//
//        List<WebElement> elementsGoalKeepersImage = driver.findElements(By.cssSelector("#__next > div.styled__ClubContainer-sc-zdygb8-0.kEuFAc > div.styled__ClubSectionContent-sc-zdygb8-8.bDNocp > div > div.styled__GridStyled-sc-skzs8h-0.cPDrdU > div:nth-child(1) > div > div.styled__GridStyled-sc-skzs8h-0.dMLeOY > div.styled__CellStyled-sc-vl6wna-0.FiwJS > div > div.styled__GridStyled-sc-skzs8h-0.gvsAFL > div > div > a > div > div.styled__ImageWrapper-sc-1cljep8-2.hclRXE > div > img"));
//        List<WebElement> elementsGoalKeepersName= driver.findElements(By.cssSelector("#__next > div.styled__ClubContainer-sc-zdygb8-0.kEuFAc > div.styled__ClubSectionContent-sc-zdygb8-8.bDNocp > div > div.styled__GridStyled-sc-skzs8h-0.cPDrdU > div:nth-child(1) > div > div.styled__GridStyled-sc-skzs8h-0.dMLeOY > div.styled__CellStyled-sc-vl6wna-0.FiwJS > div > div.styled__GridStyled-sc-skzs8h-0.gvsAFL > div > div > div > div.styled__NameContainer-sc-148d0nz-2.fAPIHU > div.styled__PlayerName-sc-148d0nz-3.bpuQkd > p.styled__TextStyled-sc-1mby3k1-0.dtQzta"));

        List<WebElement> elementsPlayersImage = driver.findElements(By.cssSelector(laligaClubsSquadURL.getImageCssSelector()));
        List<WebElement> elementsPlayersName = driver.findElements(By.cssSelector(laligaClubsSquadURL.getNameCssSelector()));
        List<WebElement> elementsTeamName = driver.findElements(By.cssSelector(laligaClubsSquadURL.getNameCssSelector()));

        List<Players> playersInfoList = savePlayersDataService.saveLaligaPlayersData(elementsPlayersImage, elementsPlayersName, elementsTeamName);


//        List<Players> playersInfoList = savePlayersDataService.saveLaligaPlayersData(elementsGoalKeepersImage, elementsGoalKeepersName, elementsPlayersImage, elementsPlayersName, elementsTeamName);

        driver.close();
        driver.quit();

        playersRepository.saveAll(playersInfoList);

    }

//    @Override
//    public void collectLeague1PlayersData(League1ClubsSquadURL league1ClubsSquadURL) throws InterruptedException {
//        WebDriver driver = webDriverUtil.connectingDriver(league1ClubsSquadURL.getUrl());
//        webDriverUtil.scrollDriver(driver);
//
//        //팝업 없애는 로직 추가
//
//
//        List<WebElement> elementsPlayers = driver.findElements(By.cssSelector(league1ClubsSquadURL.getImageCssSelector()));
//        List<WebElement> elementsTeam = driver.findElements(By.cssSelector(league1ClubsSquadURL.getNameCssSelector()));
//
//        List<Players> playersInfoList = savePlayersDataService.savePlayersData(elementsPlayers, elementsTeam);
//
//        driver.close();
//        driver.quit();
//
//        playersRepository.saveAll(playersInfoList);
//
//    }

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
