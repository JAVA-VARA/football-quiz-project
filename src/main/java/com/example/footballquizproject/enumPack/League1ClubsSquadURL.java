package com.example.footballquizproject.enumPack;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum League1ClubsSquadURL implements ClubsSquadURLProvider {
    모나코("모나코", "https://sports.daum.net/team/ligue1/1155/squad#0"),
    낭트("낭트", "https://sports.daum.net/team/ligue1/1578/squad#0"),
    로리앙("로리앙", "https://sports.daum.net/team/ligue1/1602/squad#0"),
    메스("메스", "https://sports.daum.net/team/ligue1/1587/squad#0"),
    니스("니스", "https://sports.daum.net/team/ligue1/1598/squad#0"),
    랑스("랑스", "https://sports.daum.net/team/ligue1/1591/squad#0"),
    스트라스부르("스트라스부르", "https://sports.daum.net/team/ligue1/1581/squad#0"),
    르아브르("르아브르", "https://sports.daum.net/team/ligue1/601391/squad#0"),
    릴 ("릴", "https://sports.daum.net/team/ligue1/1251/squad#0"),
    몽펠리에 ("몽펠리에 ", "https://sports.daum.net/team/ligue1/1588/squad#0"),
    랭스("랭스", "https://sports.daum.net/team/ligue1/121584/squad#0"),
    스타드_렌 ("스타드_렌", "https://sports.daum.net/team/ligue1/1594/squad#0"),
    스타드_브레스투아_29("스타드_브레스투아_29", "https://sports.daum.net/team/ligue1/1792/squad#0"),
    마르세유("마르세유", "https://sports.daum.net/team/ligue1/1218/squad#0"),
    리옹 ("리옹", "https://sports.daum.net/team/ligue1/1260/squad#0"),
    클레르몽_푸트("클레르몽_푸트", "https://sports.daum.net/team/ligue1/601206/squad#0"),
    툴루즈 ("툴루즈", "https://sports.daum.net/team/ligue1/1267/squad#0"),
    파리  ("파리 ", "https://sports.daum.net/team/ligue1/1191/squad#0"),

    ;

    private final String team;
    private final String url;

    @Override
    public String getSeasonCssSelector() {
        return CssSelectorPlayersByLeague.PLAYERS_SELECTOR_DAUM_SPORT.getSeason();
    }

    @Override
    public String getImageCssSelector(){

        return CssSelectorPlayersByLeague.PLAYERS_SELECTOR_DAUM_SPORT.getSelectPlayerImage();
    }

    @Override
    public String getNameCssSelector(){

        return CssSelectorPlayersByLeague.PLAYERS_SELECTOR_DAUM_SPORT.getSelectPlayerName();
    }

    @Override
    public String getTeamCssSelector() {

        return CssSelectorPlayersByLeague.PLAYERS_SELECTOR_DAUM_SPORT.getTeamName();
    }

    @Override
    public String getBackNumberCssSelector() {
        return CssSelectorPlayersByLeague.PLAYERS_SELECTOR_DAUM_SPORT.getBackNumber();
    }

    @Override
    public String getUrl(){
        return this.url;
    }

}
