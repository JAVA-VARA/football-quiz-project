package com.example.footballquizproject.enumPack;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum LeagueClubsURL {

    PREMIER_LEAGUE("PREMIER_LEAGUE", "https://www.premierleague.com/clubs","#mainContent > div.clubIndex > div > div > div.club-cards-wrapper.indexSection > ul > li > a > div.club-card__badge > span > img",
            "#mainContent > div.clubIndex > div > div > div.club-cards-wrapper.indexSection > ul > li > a > div.club-card__info > div > h2");
//    LA_LIGA("LA_LIGA", "https://www.laliga.com/en-GB/laliga-easports/clubs"),
//    SERIE_A("SERIE_A", "https://www.legaseriea.it/en/serie-a/squadre"),
//    BUNDES_LIGA("BUNDES_LIGA", "https://www.bundesliga.com/en/bundesliga/clubs"),
//    LEGUE_1("라리가", "https://www.ligue1.com/clubs/List");

    private final String league;
    private final String url;
    private final String SelectEmblem;
    private final String SelectName;

}
