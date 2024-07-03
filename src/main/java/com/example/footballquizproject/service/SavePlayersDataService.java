package com.example.footballquizproject.service;

import com.example.footballquizproject.domain.Players;
import com.example.footballquizproject.domain.TeamCategory;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
@RequiredArgsConstructor
public class SavePlayersDataService {
    private final Set<String> processedPlayers = new HashSet<>();

    public List<Players> savePlayersData(
            List<WebElement> elementsPlayersImage,
            List<WebElement> elementsPlayersName,
            List<WebElement> elementsSeason,
            List<WebElement> elementsPlayerBackNumber,
            TeamCategory team) {

        List<Players> playersInfoList = new ArrayList<>();
        for (int i = 0; i < elementsPlayersImage.size(); i++) {

            try {
                String playerImage = elementsPlayersImage.get(i).getAttribute("src");
                String playerFullName = elementsPlayersName.get(i).getText();
                String backNumberString = elementsPlayerBackNumber.get(i).getText();
                String season = elementsSeason.get(0).getText();

                Players player = createPlayer(playerImage, playerFullName, backNumberString, team, season);
                playersInfoList.add(player);

            } catch (IllegalArgumentException e) {
                System.err.println("Error crawling players data: " + e.getMessage());
            }
        }
        return playersInfoList;
    }

    private Players createPlayer(String playerImage, String playerFullName, String backNumberString,
                                 TeamCategory team, String season) {

        //daum sport에서 없는 선수 이미지 url 표시 형식
        if (playerImage.equals("https://t1.daumcdn.net/media/img-section/sports13/player/noimage/square_m.png")) {
            throw new IllegalArgumentException(team.getTeamName() + "의" + playerFullName + "선수는 사진이 없습니다.");
        }

        //누락된 정보 검사
        if (playerImage.isEmpty() || playerFullName.isEmpty() || team == null || season.isEmpty() || backNumberString.isEmpty()) {
            throw new IllegalArgumentException("누락된 선수 정보가 있습니다 : playerImage=" + playerImage
                    + ", playerFullName=" + playerFullName + ", team=" + team + ", season=" + season + ", backNumber=" + backNumberString);
        }

        //중복된 이미지 검사
        if (processedPlayers.contains(playerImage)) {
            throw new IllegalArgumentException("중복된 이미지입니다. " + playerFullName + ":" + playerImage);
        }
        processedPlayers.add(playerImage);

        //이름
        String[] fullName = playerFullName.split(" ");
        String firstName = "none";
        String middleName = "none";
        String lastName = "none";

        if (fullName.length == 2) {
            firstName = fullName[0];
            lastName = fullName[1];
        }

        if (fullName.length == 3) {
            firstName = fullName[0];
            middleName = fullName[1];
            lastName = fullName[2];
        }

        //등번호
        String backNumber = backNumberString.replace("No.", "");

        return Players.builder()
                .imageUrl(playerImage)
                .fullName(playerFullName)
                .firstName(firstName)
                .middleName(middleName)
                .lastName(lastName)
                .team(team)
                .season(season)
                .backNumber(backNumber)
                .build();
    }
}