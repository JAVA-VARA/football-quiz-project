package com.example.footballquizproject.enumPack;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum League1ClubsSquadURL implements ClubsSquadURLProvider {
    ;
    private final String team;
    private final String url;

    @Override
    public String getImageCssSelector() {
        return CssSelectorPlayersByLeague.LEGUE_1.getSelectPlayerImage();
    }

    @Override
    public String getNameCssSelector() {
        return CssSelectorPlayersByLeague.LEGUE_1.getSelectPlayerName();
    }

    @Override
    public String getUrl(){
        return this.url;
    }

}
