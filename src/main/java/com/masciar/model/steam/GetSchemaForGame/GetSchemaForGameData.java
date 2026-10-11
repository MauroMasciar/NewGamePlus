package com.masciar.model.steam.GetSchemaForGame;


public class GetSchemaForGameData {
    private String gameName;
    private String gameVersion;
    private AvailableGameStatsModel availableGameStats;

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getGameVersion() {
        return gameVersion;
    }

    public void setGameVersion(String gameVersion) {
        this.gameVersion = gameVersion;
    }

    public AvailableGameStatsModel getAvailableGameStats() {
        return availableGameStats;
    }

    public void setAvailableGameStats(AvailableGameStatsModel availableGameStats) {
        this.availableGameStats = availableGameStats;
    }
}
