package com.example.footballquizproject.enumPack;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SerieAClubsSquadURL implements ClubsSquadURLProvider {
    ARSENAL("Arsenal", "https://www.premierleague.com/clubs/1/Arsenal/squad?se=578"),
    ASTON_VILLA("Aston Villa", "https://www.premierleague.com/clubs/2/Aston-Villa/squad?se=578"),
    BOURNEMOUTH("Bournemouth", "https://www.premierleague.com/clubs/127/Bournemouth/squad?se=578"),
    BRENTFORD("Brentford", "https://www.premierleague.com/clubs/130/Brentford/squad?se=578"),
    BRIGHTON("Brighton", "https://www.premierleague.com/clubs/131/Brighton-and-Hove-Albion/squad?se=578"),
    BURNLEY("Burnley", "https://www.premierleague.com/clubs/43/Burnley/squad?se=578"),
    CHELSEA("Chelsea", "https://www.premierleague.com/clubs/4/Chelsea/squad?se=578"),
    CRYSTAL_PALACE("Crystal Palace", "https://www.premierleague.com/clubs/6/Crystal-Palace/squad?se=578"),
    EVERTON("Everton", "https://www.premierleague.com/clubs/7/Everton/squad?se=578"),
    FULHAM("Fulham", "https://www.premierleague.com/clubs/34/Fulham/squad?se=578"),
    LIVERPOOL("Liverpool", "https://www.premierleague.com/clubs/10/Liverpool/squad?se=578"),
    LUTON_TOWN("Luton Town", "https://www.premierleague.com/clubs/163/Luton-Town/squad?se=578"),
    MANCHESTER_CITY("Manchester City", "https://www.premierleague.com/clubs/11/Manchester-City/squad?se=578"),
    MANCHESTER_UNITED("Manchester United", "https://www.premierleague.com/clubs/12/Manchester-United/squad?se=578"),
    NEWCASTLE_UNITED("Newcastle United", "https://www.premierleague.com/clubs/23/Newcastle-United/squad?se=578"),
    NOTTINGHAM("Nottingham", "https://www.premierleague.com/clubs/15/Nottingham-Forest/squad?se=578"),
    SHEFFIELD_UNITED("Sheffield United", "https://www.premierleague.com/clubs/18/Sheffield-United/squad?se=578"),
    TOTTENHAM_HOTSPUR("Tottenham Hotspur", "https://www.premierleague.com/clubs/21/Tottenham-Hotspur/squad?se=578"),
    WEST_HAM_UNITED("West Ham United", "https://www.premierleague.com/clubs/25/West-Ham-United/squad?se=578"),
    WOLVERHAMPTON_WANDERERS("Wolverhampton Wanderers", "https://www.premierleague.com/clubs/38/Wolverhampton-Wanderers/squad?se=578");

    private final String team;
    private final String url;

    @Override
    public String getImageCssSelector() {
        return CssSelectorPlayersByLeague.SERIE_A.getSelectPlayerImage();
    }

    @Override
    public String getNameCssSelector() {
        return CssSelectorPlayersByLeague.SERIE_A.getSelectPlayerName();
    }

    @Override
    public String getTeamCssSelector() {
        return null;
    }

    @Override
    public String getUrl(){
        return this.url;
    }

}
