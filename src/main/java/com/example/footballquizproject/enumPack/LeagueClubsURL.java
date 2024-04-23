package com.example.footballquizproject.enumPack;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum LeagueClubsURL {

    PREMIER_LEAGUE("PREMIER_LEAGUE",
            "https://www.premierleague.com/clubs",
            "#mainContent > div.clubIndex > div > div > div.club-cards-wrapper.indexSection > ul > li > a > div.club-card__badge > span > img",
            "#mainContent > div.clubIndex > div > div > div.club-cards-wrapper.indexSection > ul > li > a > div.club-card__info > div > h2");

//    LA_LIGA("LA_LIGA",
//            "https://www.laliga.com/en-GB/laliga-easports/clubs",
//            "#__next > div.styled__ClubsWrapper-sc-fyva03-0.kLEcxI > div.styled__PaddingDiv-sc-fyva03-7.iOHiNO > div > div > div.styled__GridStyled-sc-skzs8h-0.fVbFTE > div > a > div.styled__AvatarContainer-sc-fyva03-2.fpOkUs > div > div.styled__ImageWrapper-sc-1cljep8-2.hclRXE > div > img",
//            "#__next > div.styled__ClubsWrapper-sc-fyva03-0.kLEcxI > div.styled__PaddingDiv-sc-fyva03-7.iOHiNO > div > div > div.styled__GridStyled-sc-skzs8h-0.fVbFTE > div > a > div.content-container > h2");

//    SERIE_A("SERIE_A",
//            "https://www.legaseriea.it/en/serie-a/squadre",
//            "#main > div.container-fluid.hm-container-fluid.hm-container-spacing-top > div.hm-block-grid-5.hm-block-grid-2-tablet.hm-block-grid-1-mobile > div > div > div.logo.d-flex.align-content-center.flex-wrap > img",
//            "#main > div.container-fluid.hm-container-fluid.hm-container-spacing-top > div.hm-block-grid-5.hm-block-grid-2-tablet.hm-block-grid-1-mobile > div > div > div.hm-info-block-tablet > h2");

//    BUNDES_LIGA("BUNDES_LIGA",
//            "https://www.bundesliga.com/en/bundesliga/clubs",
//            "#default > div > clubs-page > div > div > club-card > a > div > clublogo > img",
//            "#default > div > clubs-page > div > div > club-card > a > div > div > div.club");
//
//    LEGUE_1("LEAGUE_1",
//            "https://www.ligue1.com/clubs/List",
//            "#CompetitionClubsListPage > div.ClubListPage-container.container > div > a > div > div.ClubListPage-logo > img",
//            "#CompetitionClubsListPage > div.ClubListPage-container.container > div > a > div > div.ClubListPage-name > h3");

    private final String league;
    private final String url;
    private final String SelectEmblem;
    private final String SelectName;
}
