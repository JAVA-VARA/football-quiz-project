package com.example.footballquizproject.enumPack;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CssSelectorPlayersByLeague {

//    PREMIER_LEAGUE(
//            "#mainContent > div.wrapper.col-12 > div > ul > div > ul > li > a > div > div.stats-card__top-section > div > img.statCardImg.statCardPlayer",
//            "#mainContent > header > div.club-header__content > div > h2",
//            ""),

    PREMIER_LEAGUE(
            "#teamViewSquadWrap > ul > li > a > span > img",
            "#teamViewSquadWrap > ul> li > a > div > strong",
            "#teamViewTeamInfo > div.basic_feature > div > h3"),


    LA_LIGA(
            "#__next > div.styled__ClubContainer-sc-zdygb8-0.kEuFAc > div.styled__ClubSectionContent-sc-zdygb8-8.bDNocp > div > div.styled__GridStyled-sc-skzs8h-0.cPDrdU > div:nth-child(1) > div > div > div.styled__GridStyled-sc-skzs8h-0.gvsAFL > div > div > a > div > div.styled__ImageWrapper-sc-1cljep8-2.hclRXE > div > img",
            "#__next > div.styled__ClubContainer-sc-zdygb8-0.kEuFAc > div.styled__ClubSectionContent-sc-zdygb8-8.bDNocp > div > div.styled__GridStyled-sc-skzs8h-0.cPDrdU > div:nth-child(1) > div > div > div.styled__GridStyled-sc-skzs8h-0.gvsAFL > div > div > div > div.styled__NameContainer-sc-148d0nz-2.fAPIHU > div.styled__PlayerName-sc-148d0nz-3.bpuQkd > p.styled__TextStyled-sc-1mby3k1-0.dtQzta",
            "#__next > div.styled__ClubContainer-sc-zdygb8-0.kEuFAc > div.styled__ClubHeader-sc-zdygb8-1.cKoSCg > div > div > div.styled__Bread-sc-zdygb8-4.gRQSHm > div > span"),

//    LA_LIGA(
//            "#app > div > div.I-Dt9vZi > div.yMa1dxvd > div > div.CKFvhMRi > div > div > div > div > div > div > table > tbody > tr:nth-child(2) > td > div > div > dl > dd > div > div > table > tbody > tr > td > div > div > a > span > span > img.W0Vl59Hf",
//            "#app > div > div.I-Dt9vZi > div.yMa1dxvd > div > div.CKFvhMRi > div > div > div > div > div > div > table > tbody > tr:nth-child(2) > td > div > div > dl > dd > div > div > table > tbody > tr > td > div > span > a",
//            "#app > div > div.I-Dt9vZi > div.yMa1dxvd > article > div.cMNvtK5H > div.SRgv634M > h1 > a > span"),


//#app > div > div.I-Dt9vZi > div.yMa1dxvd > div > div.CKFvhMRi > div > div:nth-child(3) > div > div > div:nth-child(39) > div.wtwRx7lj.xaobRhuj > table > tbody > tr:nth-child(2) > td > div > div > dl > dd > div > div.wtwRx7lj > table > tbody > tr:nth-child(4) > td:nth-child(3) > div > span > a

//레알.꼬마 사진
//레 #app > div > div.I-Dt9vZi > div.yMa1dxvd > div > div.CKFvhMRi > div > div > div > div > div > div > table > tbody > tr:nth-child(2) > td > div > div > dl > dd > div > div > table > tbody > tr > td > div > div > a > span > span > img.W0Vl59Hf
//꼬 #app > div > div.I-Dt9vZi > div.yMa1dxvd > div > div.CKFvhMRi > div > div > div > div > div > div > table > tbody > tr:nth-child(2) > td > div > div > dl > dd > div > div > table > tbody > tr > td > div > div > a > span > span > img.W0Vl59Hf",

    //구 #app > div > div.I-Dt9vZi > div.yMa1dxvd > div > div.CKFvhMRi > div > div > div > div > div > div > table > tbody > tr:nth-child(2) > td > div > div > dl > dd > div > div > table > tbody > tr > td > div > div > a
    //뉴 #app > div > div.I-Dt9vZi > div.yMa1dxvd > div > div.CKFvhMRi > div > div > div > div > div > div > table > tbody > tr:nth-child(2) > td > div > div > dl > dd > div > div > table > tbody > tr > td > div > span > a

////레알.꼬마 이름
//
//    #app > div > div.I-Dt9vZi > div.yMa1dxvd > div > div.CKFvhMRi > div > div > div > div > div > div > table > tbody > tr:nth-child(2) > td > div > div > dl > dd > div > div > table > tbody > tr > td > div > div > a",

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
