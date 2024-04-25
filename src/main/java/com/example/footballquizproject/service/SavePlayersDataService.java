package com.example.footballquizproject.service;

import com.example.footballquizproject.domain.Players;
import com.example.footballquizproject.domain.TeamCategory;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SavePlayersDataService {

    List<Players> savePlayersData(List<WebElement> elementsPlayersImage, List<WebElement> elementsPlayersName, TeamCategory team, String season, List<WebElement> elementsPlayerBackNumber){

        List<Players> playersInfoList = new ArrayList<>();


        for(int i=0; i < elementsPlayersImage.size(); i++){
            //사진
            String playerImage = elementsPlayersImage.get(i).getAttribute("src");
            if(playerImage.equals("https://t1.daumcdn.net/media/img-section/sports13/player/noimage/square_m.png")){
                continue;
            }

            //이름
            String playerFullName = elementsPlayersName.get(i).getText();
            String[] fullName = playerFullName.split(" ");
            String firstName = "none";
            String lastName ="none";

            if(fullName.length > 1){
                firstName = fullName[0];
                lastName = String.join(" ", Arrays.copyOfRange(fullName, 1, fullName.length));
            }

            //등번호
            String backNumberString = elementsPlayerBackNumber.get(i).getText();
            String backNumber = backNumberString.replace("No.", "");

            Players player = Players.builder()
                    .imageUrl(playerImage)
                    .fullName(playerFullName)
                    .firstname(firstName)
                    .lastname(lastName)
                    .team(team)
                    .season(season)
                    .backNumber(backNumber)
                    .build();

            playersInfoList.add(player);
        }
        return playersInfoList;
    }
}

//    private TeamCategory getTeamInfo(List<WebElement> elements){
//        String teamName = elements.get(0).getText();
//        return teamCategoryRepository.findTeamCategoriesByTeamName(teamName);
//    }




//    private void save(List<WebElement> elementsPlayersImage, List<WebElement> elementsPlayersName, TeamCategory team, List<Players> playersInfoList) {
//        for(int i =0; i < elementsPlayersImage.size(); i++){
//
//            String playerImage = elementsPlayersImage.get(i).getAttribute("src");
//            String playerName = elementsPlayersName.get(i).getText();
//
//            Players player = Players.builder()
//                    .imageUrl(playerImage) // 이미지 링크
//                    .name(playerName)// 이름
//                    .team(team)
//                    .build();
//
//            playersInfoList.add(player);
//
//        }
//    }
//    public List<Players> saveLaligaPlayersData(List<WebElement> elementsPlayersImage, List<WebElement> elementsPlayersName, List<WebElement> elementsTeamName) {
//
//        TeamCategory team = getTeamInfo(elementsTeamName);
//
//        List<Players> playersInfoList = new ArrayList<>();
//
//        for(int i =0; i < elementsPlayersImage.size(); i++){
//
//            String playerImage = elementsPlayersImage.get(i).getAttribute("src");
//            String playerName = elementsPlayersName.get(i).getAttribute("title");
//
//            Players player = Players.builder()
//                    .imageUrl(playerImage) // 이미지 링크
//                    .name(playerName)// 이름
//                    .team(team)
//                    .build();
//
//            playersInfoList.add(player);
//
//        }
//        return playersInfoList;
//
//    }




//    public List<Players> saveLaligaPlayersData(List<WebElement> elementsGoalKeepersImage, List<WebElement> elementsGoalKeepersName, List<WebElement> elementsPlayersImage, List<WebElement> elementsPlayersName, List<WebElement> elementsTeamName) {
//        TeamCategory team = getTeamInfo(elementsTeamName);
//        List<Players> playersInfoList = new ArrayList<>();
//
//        save(elementsPlayersImage, elementsPlayersName, team, playersInfoList);
//        save(elementsGoalKeepersImage, elementsGoalKeepersName, team, playersInfoList);
//
//        return playersInfoList;
//    }



//        for (WebElement element : elementsPlayers) {
//
//            String playerImage = element.getAttribute("src");
//
//            if(playerImage.contains("Photo-Missing")){
//                continue;
//            }
//
//
//            String playerName = element.getAttribute("alt");
//
//            Players player = Players.builder()
//                    .imageUrl(playerImage) // 이미지 링크
//                    .name(playerName)// 이름
//                    .team(team)
//                    .build();
//
//            playersInfoList.add(player);
//        }
