//package com.example.footballquizproject.service;
//
//import com.example.footballquizproject.domain.Players;
//import com.example.footballquizproject.enumPack.ClubsSquadURLProvider;
//import com.example.footballquizproject.repository.PlayersRepository;
//import com.example.footballquizproject.util.WebDriverUtil;
//import lombok.RequiredArgsConstructor;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class CollectDataLeague1PlayersDataImpl implements CollectDataService {
//
//    private final PlayersRepository playersRepository;
//    private final WebDriverUtil webDriverUtil;
//    private final SavePlayersDataService savePlayersDataService;
//    @Override
//    public void collectPlayersData(ClubsSquadURLProvider squadURL) throws InterruptedException {
//        WebDriver driver = webDriverUtil.connectingDriver(squadURL.getUrl());
//        webDriverUtil.scrollDriver(driver);
//
//        //팝업 종료
//
//        List<WebElement> elementsPlayers = driver.findElements(By.cssSelector(squadURL.getImageCssSelector()));
//        List<WebElement> elementsTeam = driver.findElements(By.cssSelector(squadURL.getNameCssSelector()));
//
//        List<Players> playersInfoList = savePlayersDataService.savePlayersData(elementsPlayers, elementsTeam);
//
//        driver.close();
//        driver.quit();
//
//        playersRepository.saveAll(playersInfoList);
//    }
//}
