package com.example.footballquizproject.service;

import com.example.footballquizproject.domain.LeagueCategory;
import com.example.footballquizproject.domain.TeamCategory;
import com.example.footballquizproject.enumPack.LeagueClubsURL;
import com.example.footballquizproject.repository.LeagueCategoryRepository;
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
public class CollectTeamPremierLeague {
    private final TeamCategoryRepository teamCategoryRepository;
    private final LeagueCategoryRepository leagueCategoryRepository;
    private final WebDriverUtil webDriverUtil;
    public void getTeamData(LeagueClubsURL leagueClubs) throws InterruptedException {

        WebDriver driver = webDriverUtil.connectingDriver(leagueClubs.getUrl());
        webDriverUtil.scrollDriver(driver);

        List<WebElement> teamImgElements = driver.findElements(By.cssSelector(leagueClubs.getSelectEmblem()));
        List<WebElement> teamNameElements = driver.findElements(By.cssSelector(leagueClubs.getSelectName()));

        String league = leagueClubs.getLeague();
        List<TeamCategory> teamCategoryList = saveTeamData(teamImgElements,teamNameElements, league);

        driver.close();
        driver.quit();

        teamCategoryRepository.saveAll(teamCategoryList);

    }

    private List<TeamCategory>  saveTeamData(List<WebElement> imgElements, List<WebElement> nameElements, String leagueName){
        LeagueCategory leagueCategory = leagueCategoryRepository.findLeagueCategoryByLeague(leagueName);
        List<TeamCategory> teamCategoryList = new ArrayList<>();

        for(int i =0; i < imgElements.size() ; i++){
            String teamEmblem = imgElements.get(i).getAttribute("src");
            String teamName = nameElements.get(i).getText();

            if(teamName.contains("FC")){
                teamName = teamName.replace(" FC", "");
            }

            TeamCategory teamCategory = TeamCategory.builder()
                    .teamName(teamName)
                    .teamEmblem(teamEmblem)
                    .league(leagueCategory)
                    .build();

            teamCategoryList.add(teamCategory);
        }
        return teamCategoryList;
    }
}


