package com.example.footballquizproject.enumPack;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum BundesLigaClubsSquadURL implements ClubsSquadURLProvider {
    ;
    private final String team;
    private final String url;

    @Override
    public String getImageCssSelector() {
        return CssSelectorPlayersByLeague.BUNDES_LIGA.getSelectPlayerImage();
    }

    @Override
    public String getNameCssSelector() {
        return CssSelectorPlayersByLeague.BUNDES_LIGA.getSelectPlayerName();
    }

    @Override
    public String getTeamCssSelector() {
        return CssSelectorPlayersByLeague.BUNDES_LIGA.getTeamname();
    }

    @Override
    public String getUrl(){
        return this.url;
    }

}
