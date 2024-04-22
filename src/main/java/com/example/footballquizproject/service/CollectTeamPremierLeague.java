package com.example.footballquizproject.service;

import com.example.footballquizproject.domain.LeagueCategory;
import com.example.footballquizproject.domain.TeamCategory;
import com.example.footballquizproject.repository.LeagueCategoryRepository;
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
public class CollectTeamPremierLeague {
    private final TeamCategoryRepository teamCategoryRepository;
    private final LeagueCategoryRepository leagueCategoryRepository;
    private final static String WEB_DRIVER_PATH = "C:\\Users\\sjyou\\Downloads\\chromedriver-win64\\chromedriver.exe";

    private static final String URL  = "https://www.premierleague.com/clubs";

    public List<TeamCategory> getTeamData() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", WEB_DRIVER_PATH);
        WebDriver driver = new ChromeDriver();
        driver.get(URL);
        Thread.sleep(1000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        Long pageHeight = (Long) js.executeScript("return document.body.scrollHeight");

        for (int i = 0; i < pageHeight; i += 1000) {
            js.executeScript("window.scrollTo(0, " + i + ")");
            Thread.sleep(1000); // 스크롤 시간을 기다림 (필요에 따라 조절)
        }

        String league = "Premier League";
        LeagueCategory leagueCategory = leagueCategoryRepository.findLeagueCategoryByLeague(league);
        List<WebElement> imgElements = driver.findElements(By.cssSelector("#mainContent > div.clubIndex > div > div > div.club-cards-wrapper.indexSection > ul > li > a > div.club-card__badge > span > img"));
        List<WebElement> nameElements = driver.findElements(By.cssSelector("#mainContent > div.clubIndex > div > div > div.club-cards-wrapper.indexSection > ul > li> a > div.club-card__info > div > h2"));

        List<TeamCategory> teamCategoryList = new ArrayList<>();
        for(int i =0; i < imgElements.size() ; i++){

            String teamEmblem = imgElements.get(i).getAttribute("src");
            String teamName = nameElements.get(i).getText();

            TeamCategory teamCategory = TeamCategory.builder()
                    .teamName(teamName)
                    .teamEmblem(teamEmblem)
                    .league(leagueCategory)
                    .build();

            teamCategoryList.add(teamCategory);
        }

        driver.close();
        driver.quit();

        teamCategoryRepository.saveAll(teamCategoryList);

        return teamCategoryList;
    }
}
