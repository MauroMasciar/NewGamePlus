package com.masciar.model.steam.GetOwnedGames;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OwnedGamesData {
    @JsonProperty("game_count")
    private int gameCount;
    private List<GameModel> games;

    public OwnedGamesData() {
    }

    public OwnedGamesData(int gameCount, List<GameModel> games) {
        this.gameCount = gameCount;
        this.games = games;
    }

    public int setGameCount() {
        return gameCount;
    }

    public void setGameCount(int gameCount) {
        this.gameCount = gameCount;
    }

    public List<GameModel> getGames() {
        return games;
    }

    public void setGames(List<GameModel> games) {
        this.games = games;
    }
}
