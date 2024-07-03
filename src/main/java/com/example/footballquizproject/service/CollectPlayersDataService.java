package com.example.footballquizproject.service;

import com.example.footballquizproject.enumPack.ClubsSquadURLProvider;

public interface CollectPlayersDataService {
    void collectPlayersData(ClubsSquadURLProvider squadURL) throws InterruptedException;
}

