package com.example.footballquizproject.enumPack;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CssSelectorPlayersByLeague {

    PREMIER_LEAGUE(
            "#mainContent > div.wrapper.col-12 > div > ul > div > ul > li > a > div > div.stats-card__top-section > div > img.statCardImg.statCardPlayer",
            "#mainContent > header > div.club-header__content > div > h2",
            ""),

    LA_LIGA(
            "#__next > div.styled__ClubContainer-sc-zdygb8-0.kEuFAc > div.styled__ClubSectionContent-sc-zdygb8-8.bDNocp > div > div.styled__GridStyled-sc-skzs8h-0.cPDrdU > div:nth-child(1) > div > div > div.styled__GridStyled-sc-skzs8h-0.gvsAFL > div > div > a > div > div.styled__ImageWrapper-sc-1cljep8-2.hclRXE > div > img",
            "#__next > div.styled__ClubContainer-sc-zdygb8-0.kEuFAc > div.styled__ClubSectionContent-sc-zdygb8-8.bDNocp > div > div.styled__GridStyled-sc-skzs8h-0.cPDrdU > div:nth-child(1) > div > div > div.styled__GridStyled-sc-skzs8h-0.gvsAFL > div > div > div > div.styled__NameContainer-sc-148d0nz-2.fAPIHU > div.styled__PlayerName-sc-148d0nz-3.bpuQkd > p.styled__TextStyled-sc-1mby3k1-0.dtQzta",
            "#__next > div.styled__ClubContainer-sc-zdygb8-0.kEuFAc > div.styled__ClubHeader-sc-zdygb8-1.cKoSCg > div > div > div.styled__Bread-sc-zdygb8-4.gRQSHm > div > span"),


    SERIE_A(
            "",
            "",
            ""),

    BUNDES_LIGA(
            "",
            "",
            ""),

    LEGUE_1(
            "",
            "",
            "");


    private final String SelectPlayerImage;
    private final String SelectPlayerName;
    private final String teamname;

}
