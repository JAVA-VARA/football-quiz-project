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
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CollectPlayersService {
    private final static String WEB_DRIVER_PATH = "C:\\Users\\sjyou\\Downloads\\chromedriver-win64\\chromedriver.exe";
    private final TeamCategoryRepository teamCategoryRepository;
    private final PlayersRepository playersRepository;

//    private static final String URL_ATM = "https://www.laliga.com/en-GB/clubs/atletico-de-madrid/squad";
//    private static final String URL_ATHLETIC_CLUB  = "https://www.laliga.com/en-GB/clubs/athletic-club/squad";

    private static final String URL_ARS  = "https://www.transfermarkt.co.uk/arsenal-fc/kader/verein/11/saison_id/2023/plus/1";



    private static final String team_name = "아틀레티코 마드리드";

    @Transactional
//    @PostConstruct
    public List<Players> getPlayersInfo() throws InterruptedException {

        TeamCategory team = teamCategoryRepository.findTeamCategoriesByTeamName(team_name);
        List<Players> playersInfoList = new ArrayList<>();

        //크롬 드라이버 셋팅 (드라이버 설치한 경로 입력)
        System.setProperty("webdriver.chrome.driver", WEB_DRIVER_PATH);

        // 크롬 드라이버 사용
        WebDriver driver = new ChromeDriver();
        driver.get(URL_ARS);
        Thread.sleep(1000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        Long pageHeight = (Long) js.executeScript("return document.body.scrollHeight");

        // 페이지 높이만큼 스크롤하면서 이미지 태그 가져오기
        for (int i = 0; i < pageHeight; i += 1000) {
            js.executeScript("window.scrollTo(0, " + i + ")");
            Thread.sleep(1000); // 스크롤 시간을 기다림 (필요에 따라 조절)
        }

//        List<WebElement> imgElements = driver.findElements(By.cssSelector("div.styled__ImageWrapper-sc-1cljep8-2.hclRXE img.styled__ImageStyled-sc-17v9b6o-0.coeclD"));
//        List<WebElement> nameElements = driver.findElements(By.cssSelector("div.styled__PlayerInfoContainer-sc-148d0nz-1.hrqESP"));

        List<WebElement> imgElements = driver.findElements(By.cssSelector("#yw1 > table > tbody > tr > td.posrela > table > tbody > tr:nth-child(1) > td:nth-child(1) > img"));

//
//        #yw1 > table > tbody > tr:nth-child(1) > td.posrela > table > tbody > tr:nth-child(1) > td:nth-child(1) > img
//        #yw1 > table > tbody > tr:nth-child(2) > td.posrela > table > tbody > tr:nth-child(1) > td:nth-child(1) > img


        for (int i = 0; i < imgElements.size(); i++) {
            String imgURL = imgElements.get(i).getAttribute("src");
//            String playerInfo = nameElements.get(i).getText();

//            String[] parts = playerInfo.split("\n");
//            String playerName = parts[0].trim();


            Players player = Players.builder()
                    .imageUrl(imgURL) // 이미지 링크
                    .name("playerName")// 이름
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


