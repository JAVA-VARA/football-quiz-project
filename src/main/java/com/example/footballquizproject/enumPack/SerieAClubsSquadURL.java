package com.example.footballquizproject.enumPack;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SerieAClubsSquadURL implements ClubsSquadURLProvider {
    피오렌티나("ACF 피오렌티나", "https://sports.daum.net/team/seriea/1091/squad#0"),
    몬차("AC 몬차", "https://sports.daum.net/team/seriea/601263/squad#0"),
    AC밀란("AC 밀란", "https://sports.daum.net/team/seriea/1088/squad#0"),
    로마("AS 로마", "https://sports.daum.net/team/seriea/1089/squad#0"),
    인테르나치오날레("FC 인테르나치오날레", "https://sports.daum.net/team/seriea/1099/squad#0"),
    나폴리("SSC 나폴리", "https://sports.daum.net/team/seriea/1100/squad#0"),
    라치오("SS 라치오", "https://sports.daum.net/team/seriea/1094/squad#0"),
    레체("US 레체", "https://sports.daum.net/team/seriea/1113/squad#0"),
    사수올로 ("US 사수올로 칼초", "https://sports.daum.net/team/seriea/227478/squad#0"),
    살레르니타나("US 살레르니타나", "https://sports.daum.net/team/seriea/601208/squad#0"),
    볼로냐("볼로냐 FC", "https://sports.daum.net/team/seriea/1102/squad#0"),
    아탈란타 ("아탈란타 BC", "https://sports.daum.net/team/seriea/1105/squad#0"),
    베로나("엘라스 베로나", "https://sports.daum.net/team/seriea/227477/squad#0"),
    엠폴리("엠폴리 FC", "https://sports.daum.net/team/seriea/1110/squad#0"),
    우디네세 ("우디네세 칼초", "https://sports.daum.net/team/seriea/1098/squad#0"),
    유벤투스("유벤투스 FC", "https://sports.daum.net/team/seriea/1093/squad#0"),
    제노아 ("제노아 CFC", "https://sports.daum.net/team/seriea/1092/squad#0"),
    칼리아리 ("칼리아리 칼초", "https://sports.daum.net/team/seriea/1101/squad#0"),
    토리노("토리노 FC", "https://sports.daum.net/team/seriea/1097/squad#0"),
    프로시노네 ("프로시노네 칼초", "https://sports.daum.net/team/seriea/436864/squad#0");

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
    public String getBackNumberCssSelector() {
        return CssSelectorPlayersByLeague.PLAYERS_SELECTOR_DAUM_SPORT.getBackNumber();
    }

    @Override
    public String getUrl(){
        return this.url;
    }

    @Override
    public String getTeam(){
        return this.team;
    }

}
