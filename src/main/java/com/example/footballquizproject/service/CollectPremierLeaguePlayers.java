package com.example.footballquizproject.service;

import com.example.footballquizproject.domain.Players;
import com.example.footballquizproject.domain.TeamCategory;
import com.example.footballquizproject.repository.PlayersRepository;
import com.example.footballquizproject.repository.TeamCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CollectPremierLeaguePlayers {
    private final static String WEB_DRIVER_PATH = "C:\\Users\\sjyou\\Downloads\\chromedriver-win64\\chromedriver.exe";
    private final TeamCategoryRepository teamCategoryRepository;
    private final PlayersRepository playersRepository;

    public List<Players> PremierLeaguePlayersData() throws InterruptedException {

        String URL_ARS = "https://www.premierleague.com/clubs/1/Arsenal/squad?se=578";
//        String URL_AV = "https://www.premierleague.com/clubs/2/Aston-Villa/squad?se=578";
//        String URL_AFC_B =  "https://https://www.premierleague.com/clubs/127/Bournemouth/squad?se=578";

        System.setProperty("webdriver.chrome.driver", WEB_DRIVER_PATH);
        WebDriver driver = new ChromeDriver();
        driver.get(URL_ARS);
        Thread.sleep(5000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        Long pageHeight = (Long) js.executeScript("return document.body.scrollHeight");

        for (int i = 0; i < pageHeight; i += 1000) {
            js.executeScript("window.scrollTo(0, " + i + ")");
            Thread.sleep(500); // 스크롤 시간을 기다림 (필요에 따라 조절)
        }

        List<WebElement> elements = driver.findElements(By.cssSelector("#mainContent > div.wrapper.col-12 > div > ul > div > ul > li > a > div > div.stats-card__top-section > div.stats-card__player-image.js-featured-player-image.t3 > img"));


        List<WebElement> elementTeam = driver.findElements(By.cssSelector("#mainContent > header.club-header.club-header--t3"));

//        "#mainContent > header.club-header.club-header--t3 > div.club-header__text-content
        String header = elementTeam.get(0).getText();

        String[] headerInfo = header.split("\n") ;
        String teamname = headerInfo[0];

        TeamCategory team = teamCategoryRepository.findTeamCategoriesByTeamName(teamname);

        List<Players> playersInfoList = new ArrayList<>();
        for (WebElement element : elements) {

            String playerImage = element.getAttribute("src");
            String playerName = element.getAttribute("alt");

            Players player = Players.builder()
                    .imageUrl(playerImage) // 이미지 링크
                    .name(playerName)// 이름
                    .team(team)
                    .build();

            playersInfoList.add(player);

        }

        driver.close();
        driver.quit();

        playersRepository.saveAll(playersInfoList);

        return playersInfoList;

    }
}
