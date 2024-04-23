package com.example.footballquizproject.enumPack;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LaligaClubsSquadURL implements ClubsSquadURLProvider  {
    //라리가
    ATHLETIC_CLUB("ATHLETIC CLUB", "https://www.laliga.com/en-GB/clubs/athletic-club/squad"),
    ATLETICO_DE_MADRID("ATLETICO_DE_MADRID", "https://www.laliga.com/en-GB/clubs/atletico-de-madrid/squad"),
    OSASUNA("OSASUNA", "https://www.laliga.com/en-GB/clubs/c-a-osasuna/squad"),
    CADIZ("CADIZ", "https://www.laliga.com/en-GB/clubs/cadiz-cf/squad"),
    DEPORTIVO_ALAVÉS("DEPORTIVO_ALAVES", "https://www.laliga.com/en-GB/clubs/d-alaves/squad"),
    BARCELONA ("BARCELONA", "https://www.laliga.com/en-GB/clubs/fc-barcelona/squad"),
    GETAFE  ("GETAFE", "https://www.laliga.com/en-GB/clubs/getafe-cf/squad"),
    GIRONA ("GIRONA", "https://www.laliga.com/en-GB/clubs/girona-fc/squad"),
    GRANADA  ("GRANADA", "https://www.laliga.com/en-GB/clubs/granada-cf/squad"),
    RAYO_VALLECANO("RAYO VALLECANO", "https://www.laliga.com/en-GB/clubs/rayo-vallecano/squad"),
    CELTA("CELTA", "https://www.laliga.com/en-GB/clubs/rc-celta/squad"),
    MALLORCA("MALLORCA", "https://www.laliga.com/en-GB/clubs/rcd-mallorca/squad"),
    REAL_BETIS("REAL BETIS", "https://www.laliga.com/en-GB/clubs/real-betis/squad"),
    REAL_MADRID("REAL MADRID", "https://www.laliga.com/en-GB/clubs/real-madrid/squad"),
    REAL_SOCIEDAD("REAL SOCIEDAD","https://www.laliga.com/en-GB/clubs/real-sociedad/squad"),
    SEVILLA("SEVILLA", "https://www.laliga.com/en-GB/clubs/sevilla-fc/squad"),
    ALMERIA ("ALMERIA", "https://www.laliga.com/en-GB/clubs/ud-almeria/squad"),
    LAS_PALMAS("LAS_PALMAS", "https://www.laliga.com/en-GB/clubs/ud-las-palmas/squad"),
    VALENCIA ("VALENCIA", "https://www.laliga.com/en-GB/clubs/valencia-cf/squad"),
    VILLARREAL ("VILLARREAL", "https://www.laliga.com/en-GB/clubs/villarreal-cf/squad");

    private final String team;
    private final String url;

    @Override
    public String getImageCssSelector(){

        return CssSelectorPlayersByLeague.LA_LIGA.getSelectPlayerImage();
    }
    @Override
    public String getNameCssSelector(){

        return CssSelectorPlayersByLeague.LA_LIGA.getSelectPlayerName();
    }

    @Override
    public String getUrl(){
        return this.url;
    }

}