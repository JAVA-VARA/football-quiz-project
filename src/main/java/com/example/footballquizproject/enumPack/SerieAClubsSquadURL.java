package com.example.footballquizproject.enumPack;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SerieAClubsSquadURL implements ClubsSquadURLProvider {
    ;
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
    public String getUrl(){
        return this.url;
    }

}
