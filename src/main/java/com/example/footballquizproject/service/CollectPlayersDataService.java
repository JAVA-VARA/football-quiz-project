package com.example.footballquizproject.service;

import com.example.footballquizproject.enumPack.ClubsSquadURLProvider;
import com.example.footballquizproject.enumPack.LaligaClubsSquadURL;

public interface CollectPlayersDataService {
    void collectPlayersData(ClubsSquadURLProvider squadURL) throws InterruptedException;

    void collectLaligaPlayersData(LaligaClubsSquadURL laligaClubsSquadURL) throws InterruptedException;

//    void collectLeague1PlayersData(League1ClubsSquadURL league1ClubsSquadURL) throws InterruptedException;

}

//    List<Players> savePlayersData(List<WebElement> elementsPlayers, List<WebElement> elementsTeam);
