package com.example.footballquizproject.enumPack;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EPLClubsSquadURL implements ClubsSquadURLProvider  {
    BOURNEMOUTH("AFC 본머스", "https://sports.daum.net/team/epl/310/squad#0"),
    NOTTINGHAM("노팅엄 포레스트 FC", "https://sports.daum.net/team/epl/269/squad#0"),
    NEWCASTLE_UNITED("뉴캐슬 유나이티드", "https://sports.daum.net/team/epl/1321/squad#0"),
    LUTON_TOWN("루턴 타운 FC", "https://sports.daum.net/team/epl/1888/squad#0"),
    LIVERPOOL("리버풀 FC", "https://sports.daum.net/team/epl/253/squad#0"),
    MANCHESTER_CITY("맨체스터 시티 FC", "https://sports.daum.net/team/epl/258/squad#0"),
    MANCHESTER_UNITED("맨체스터 유나이티드", "https://sports.daum.net/team/epl/246/squad#0"),
    BURNLEY("번리 FC", "https://sports.daum.net/team/epl/263/squad#0"),
    BRIGHTON("브라이튼 앤 호브 알비온 FC", "https://sports.daum.net/team/epl/277/squad#0"),
    BRENTFORD("브렌트포드 FC", "https://sports.daum.net/team/epl/313/squad#0"),
    SHEFFIELD_UNITED("셰필드 유나이티드 FC", "https://sports.daum.net/team/epl/286/squad#0"),
    ARSENAL("아스널 FC", "https://sports.daum.net/team/epl/247/squad#0"),
    ASTON_VILLA("애스턴 빌라 FC", "https://sports.daum.net/team/epl/250/squad#0"),
    EVERTON("에버턴 FC", "https://sports.daum.net/team/epl/252/squad#0"),
    WOLVERHAMPTON_WANDERERS("울버햄튼 원더러스 FC", "https://sports.daum.net/team/epl/256/squad#0"),
    WEST_HAM_UNITED("웨스트햄 유나이티드", "https://sports.daum.net/team/epl/254/squad#0"),
    CHELSEA("첼시 FC", "https://sports.daum.net/team/epl/251/squad#0"),
    CRYSTAL_PALACE("크리스탈 팰리스 FC", "https://sports.daum.net/team/epl/274/squad#0"),
    FULHAM("풀럼 FC", "https://sports.daum.net/team/epl/260/squad#0"),
    TOTTENHAM_HOTSPUR("토트넘 홋스퍼", "https://sports.daum.net/team/epl/249/squad#0"),
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

//프리미어리그
//    ARSENAL("Arsenal", "https://www.premierleague.com/clubs/1/Arsenal/squad?se=578"),
//    ASTON_VILLA("Aston Villa", "https://www.premierleague.com/clubs/2/Aston-Villa/squad?se=578"),
//    BOURNEMOUTH("Bournemouth", "https://www.premierleague.com/clubs/127/Bournemouth/squad?se=578"),
//    BRENTFORD("Brentford", "https://www.premierleague.com/clubs/130/Brentford/squad?se=578"),
//    BRIGHTON("Brighton", "https://www.premierleague.com/clubs/131/Brighton-and-Hove-Albion/squad?se=578"),
//    BURNLEY("Burnley", "https://www.premierleague.com/clubs/43/Burnley/squad?se=578"),
//    CHELSEA("Chelsea", "https://www.premierleague.com/clubs/4/Chelsea/squad?se=578"),
//    CRYSTAL_PALACE("Crystal Palace", "https://www.premierleague.com/clubs/6/Crystal-Palace/squad?se=578"),
//    EVERTON("Everton", "https://www.premierleague.com/clubs/7/Everton/squad?se=578"),
//    FULHAM("Fulham", "https://www.premierleague.com/clubs/34/Fulham/squad?se=578"),
//    LIVERPOOL("Liverpool", "https://www.premierleague.com/clubs/10/Liverpool/squad?se=578"),
//    LUTON_TOWN("Luton Town", "https://www.premierleague.com/clubs/163/Luton-Town/squad?se=578"),
//    MANCHESTER_CITY("Manchester City", "https://www.premierleague.com/clubs/11/Manchester-City/squad?se=578"),
//    MANCHESTER_UNITED("Manchester United", "https://www.premierleague.com/clubs/12/Manchester-United/squad?se=578"),
//    NEWCASTLE_UNITED("Newcastle United", "https://www.premierleague.com/clubs/23/Newcastle-United/squad?se=578"),
//    NOTTINGHAM("Nottingham", "https://www.premierleague.com/clubs/15/Nottingham-Forest/squad?se=578"),
//    SHEFFIELD_UNITED("Sheffield United", "https://www.premierleague.com/clubs/18/Sheffield-United/squad?se=578"),
//    TOTTENHAM_HOTSPUR("Tottenham Hotspur", "https://www.premierleague.com/clubs/21/Tottenham-Hotspur/squad?se=578"),
//    WEST_HAM_UNITED("West Ham United", "https://www.premierleague.com/clubs/25/West-Ham-United/squad?se=578"),
//    WOLVERHAMPTON_WANDERERS("Wolverhampton Wanderers", "https://www.premierleague.com/clubs/38/Wolverhampton-Wanderers/squad?se=578");