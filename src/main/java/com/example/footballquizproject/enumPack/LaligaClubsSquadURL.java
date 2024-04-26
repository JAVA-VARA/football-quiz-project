package com.example.footballquizproject.enumPack;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LaligaClubsSquadURL implements ClubsSquadURLProvider  {
    OSASUNA("CA 오사수나", "https://sports.daum.net/team/primera/1070/squad#0"),
    BARCELONA ("FC 바르셀로나", "https://sports.daum.net/team/primera/1059/squad#0"),
    MALLORCA("RCD 마요르카", "https://sports.daum.net/team/primera/1075/squad#0"),
    LAS_PALMAS("UD 라스팔마스", "https://sports.daum.net/team/primera/434989/squad#0"),
    ALMERIA ("UD 알메리아", "https://sports.daum.net/team/primera/1084/squad#0"),
    GRANADA  ("그라나다 CF", "https://sports.daum.net/team/primera/35956/squad#0"),
    DEPORTIVO_ALAVÉS("데포르티보 알라베스", "https://sports.daum.net/team/primera/1080/squad#0"),
    RAYO_VALLECANO("라요 바예카노", "https://sports.daum.net/team/primera/35955/squad#0"),
    REAL_MADRID("레알 마드리드", "https://sports.daum.net/team/primera/1062/squad#0"),
    REAL_BETIS("레알 베티스", "https://sports.daum.net/team/primera/1061/squad#0"),
    REAL_SOCIEDAD("레알 소시에다드","https://sports.daum.net/team/primera/1063/squad#0"),
    VALENCIA ("발렌시아 CF", "https://sports.daum.net/team/primera/1067/squad#0"),
    VILLARREAL ("비야레알 CF", "https://sports.daum.net/team/primera/1068/squad#0"),
    SEVILLA("세비야", "https://sports.daum.net/team/primera/1073/squad#0"),
    CELTA("셀타 비고", "https://sports.daum.net/team/primera/1071/squad#0"),
    ATLETICO_DE_MADRID("아틀레티코 마드리드", "https://sports.daum.net/team/primera/1058/squad#0"),
    ATHLETIC_CLUB("아틀레틱 빌바오", "https://sports.daum.net/team/primera/1057/squad#0"),
    GIRONA ("지로나", "https://sports.daum.net/team/primera/600249/squad#0"),
    CADIZ("카디스 CF", "https://sports.daum.net/team/primera/1078/squad#0"),
    GETAFE  ("헤타페 CF", "https://sports.daum.net/team/primera/1087/squad#0"),
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

    @Override
    public String getTeam(){
        return this.team;
    }

}

//    ATLETICO_DE_MADRID("ATLETICO_DE_MADRID", "https://namu.wiki/w/%EC%95%84%ED%8B%80%EB%A0%88%ED%8B%B0%EC%BD%94%20%EB%A7%88%EB%93%9C%EB%A6%AC%EB%93%9C");
//    REAL_MADRID("REAL_MADRID", "https://namu.wiki/w/%EB%A0%88%EC%95%8C%20%EB%A7%88%EB%93%9C%EB%A6%AC%EB%93%9C%20CF?from=%EB%A0%88%EC%95%8C%EB%A7%88%EB%93%9C%EB%A6%AC%EB%93%9C#s-7");

//    ATHLETIC_CLUB("ATHLETIC CLUB", "https://www.laliga.com/en-GB/clubs/athletic-club/squad");
//    ATLETICO_DE_MADRID("ATLETICO_DE_MADRID", "https://www.laliga.com/en-GB/clubs/atletico-de-madrid/squad"),
//    OSASUNA("OSASUNA", "https://www.laliga.com/en-GB/clubs/c-a-osasuna/squad"),
//    CADIZ("CADIZ", "https://www.laliga.com/en-GB/clubs/cadiz-cf/squad"),
//    DEPORTIVO_ALAVÉS("DEPORTIVO_ALAVES", "https://www.laliga.com/en-GB/clubs/d-alaves/squad"),
//    BARCELONA ("BARCELONA", "https://www.laliga.com/en-GB/clubs/fc-barcelona/squad"),
//    GETAFE  ("GETAFE", "https://www.laliga.com/en-GB/clubs/getafe-cf/squad"),
//    GIRONA ("GIRONA", "https://www.laliga.com/en-GB/clubs/girona-fc/squad"),
//    GRANADA  ("GRANADA", "https://www.laliga.com/en-GB/clubs/granada-cf/squad"),
//    RAYO_VALLECANO("RAYO VALLECANO", "https://www.laliga.com/en-GB/clubs/rayo-vallecano/squad"),
//    CELTA("CELTA", "https://www.laliga.com/en-GB/clubs/rc-celta/squad"),
//    MALLORCA("MALLORCA", "https://www.laliga.com/en-GB/clubs/rcd-mallorca/squad"),
//    REAL_BETIS("REAL BETIS", "https://www.laliga.com/en-GB/clubs/real-betis/squad"),
//    REAL_MADRID("REAL MADRID", "https://www.laliga.com/en-GB/clubs/real-madrid/squad"),
//    REAL_SOCIEDAD("REAL SOCIEDAD","https://www.laliga.com/en-GB/clubs/real-sociedad/squad"),
//    SEVILLA("SEVILLA", "https://www.laliga.com/en-GB/clubs/sevilla-fc/squad"),
//    ALMERIA ("ALMERIA", "https://www.laliga.com/en-GB/clubs/ud-almeria/squad"),
//    LAS_PALMAS("LAS_PALMAS", "https://www.laliga.com/en-GB/clubs/ud-las-palmas/squad"),
//    VALENCIA ("VALENCIA", "https://www.laliga.com/en-GB/clubs/valencia-cf/squad"),
//    VILLARREAL ("VILLARREAL", "https://www.laliga.com/en-GB/clubs/villarreal-cf/squad");