package com.example.footballquizproject.enumPack;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum BundesLigaClubsSquadURL implements ClubsSquadURLProvider {
    FC_쾰른("1. FC 쾰른", "https://sports.daum.net/team/bundesliga/1127/squad#0"),
    FC_하이덴하임_1846("1 FC 하이덴하임 1846", "https://sports.daum.net/team/bundesliga/601390/squad#0"),
    아우크스부르크("FC 아우크스부르크", "https://sports.daum.net/team/bundesliga/35957/squad#0"),
    RB_라이프치히("RB 라이프치히", "https://sports.daum.net/team/bundesliga/516328/squad#0"),
    SC_프라이부르크("SC 프라이부르크", "https://sports.daum.net/team/bundesliga/1125/squad#0"),
    SV_다름슈타트_98("SV 다름슈타트 98", "https://sports.daum.net/team/bundesliga/434990/squad#0"),
    TSG_호펜하임("TSG 호펜하임", "https://sports.daum.net/team/bundesliga/1146/squad#0"),
    VfB_슈투트가르트("VfB 슈투트가르트", "https://sports.daum.net/team/bundesliga/1129/squad#0"),
    VfL_보훔("VfL 보훔", "https://sports.daum.net/team/bundesliga/1142/squad#0"),
    VfL_볼프스부르크("VfL 볼프스부르크", "https://sports.daum.net/team/bundesliga/1143/squad#0"),
    마인츠_05("마인츠 05", "https://sports.daum.net/team/bundesliga/1145/squad#0"),
    바이어_레버쿠젠("바이어 레버쿠젠", "https://sports.daum.net/team/bundesliga/1137/squad#0"),
    바이에른_뮌헨("바이에른 뮌헨", "https://sports.daum.net/team/bundesliga/1122/squad#0"),
    베르더_브레멘("베르더 브레멘", "https://sports.daum.net/team/bundesliga/1130/squad#0"),
    보루시아_도르트문트("보루시아 도르트문트", "https://sports.daum.net/team/bundesliga/1123/squad#0"),
    보루시아_묀헨글라트바흐("보루시아 묀헨글라트바흐", "https://sports.daum.net/team/bundesliga/1132/squad#0"),
    아인트라흐트_프랑크푸르트("아인트라흐트 프랑크푸르트", "https://sports.daum.net/team/bundesliga/1124/squad#0"),
    우니온_베를린("우니온 베를린", "https://sports.daum.net/team/bundesliga/600950/squad#0"),
    ;

    private final String team;
    private final String url;

    @Override
    public String getSeasonCssSelector() {
        return CssSelectorPlayersByLeague.PLAYERS_SELECTOR_DAUM_SPORT.getSeason();
    }

    @Override
    public String getImageCssSelector() {

        return CssSelectorPlayersByLeague.PLAYERS_SELECTOR_DAUM_SPORT.getSelectPlayerImage();
    }

    @Override
    public String getNameCssSelector() {

        return CssSelectorPlayersByLeague.PLAYERS_SELECTOR_DAUM_SPORT.getSelectPlayerName();
    }
    @Override
    public String getBackNumberCssSelector() {
        return CssSelectorPlayersByLeague.PLAYERS_SELECTOR_DAUM_SPORT.getBackNumber();
    }

    @Override
    public String getUrl() {
        return this.url;
    }

    @Override
    public String getTeam(){
        return this.team;
    }

}
