package com.masciar.service;

import com.masciar.app.Main;

public class PlayerService {
    public int getTotalTimePlayed() {
        return Main.playerRepository.players_list.get(0).getTotalTime();
    }

    public int getTotalSessions() {
        return Main.playerRepository.players_list.get(0).getTotalSessions();
    }

    public int getTotalCompleted() {
        return Main.playerRepository.players_list.get(0).getCompleted();
    }

    public int getTotalStartedGames() {
        return Main.playerRepository.players_list.get(0).getTotalStarted();
    }

}
