package com.example.footballquizproject.enumPack;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CssSelectorPlayersByLeague {

    PREMIER_LEAGUE(
            "#mainContent > div.wrapper.col-12 > div > ul > div > ul > li > a > div > div.stats-card__top-section > div > img.statCardImg.statCardPlayer",
            "#mainContent > header > div.club-header__content > div > h2"),

    LA_LIGA(
            "",
            ""),



    SERIE_A(
            "",
            ""),

    BUNDES_LIGA(
            "",
            ""),

    LEGUE_1(
            "",
            "");


    private final String SelectPlayerImage;
    private final String SelectPlayerName;

}
