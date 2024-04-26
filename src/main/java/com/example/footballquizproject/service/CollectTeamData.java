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
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CollectTeamData {
    private final LeagueCategoryRepository leagueCategoryRepository;
    private final TeamCategoryRepository teamCategoryRepository;
    private final WebDriverUtil webDriverUtil;

    @Transactional
    public void collectTeamInfo(LeagueClubsURL leagueClubs) throws InterruptedException {

        WebDriver driver = webDriverUtil.connectingDriver(leagueClubs.getUrl());
        webDriverUtil.scrollDriver(driver);

        List<WebElement> teamImgElements = driver.findElements(By.cssSelector(leagueClubs.getSelectEmblem()));
        List<WebElement> teamNameElements = driver.findElements(By.cssSelector(leagueClubs.getSelectName()));

        LeagueCategory league = leagueCategoryRepository.findLeagueCategoryByLeague(leagueClubs.getLeague());
        List<TeamCategory> teamCategoryList = saveTeamData(teamImgElements,teamNameElements, league);

        league.mappingTeamToLeague(teamCategoryList);

        driver.close();
        driver.quit();
    }

    private List<TeamCategory>  saveTeamData(List<WebElement> imgElements, List<WebElement> nameElements, LeagueCategory league){

        List<TeamCategory> teamCategoryList = new ArrayList<>();

        for(int i =0; i < imgElements.size() ; i++){
            String teamEmblem = imgElements.get(i).getAttribute("src");
            String teamName = nameElements.get(i).getText();


            if(teamCategoryRepository.findByTeamName(teamName)){
                continue;
            }

            if(teamName.contains("FC")){
                teamName = teamName.replace(" FC", "");
            }

            TeamCategory teamCategory = TeamCategory.builder()
                    .teamName(teamName)
                    .teamEmblem(teamEmblem)
                    .league(league)
                    .build();

            teamCategoryList.add(teamCategory);
        }

        return teamCategoryList;
    }
}


