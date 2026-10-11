package com.masciar.model.steam.GetPlayerAchievements;

import java.util.List;

public class GetOwnerAchievementsData {
    private String steamID;
    private String gameName;
    private boolean success;
    private List<PlayerAchievementsModel> achievements;

    public GetOwnerAchievementsData() {
    }

    public GetOwnerAchievementsData(String steamID, String gameName, boolean success, List<PlayerAchievementsModel> achievements) {
        this.steamID = steamID;
        this.gameName = gameName;
        this.success = success;
        this.achievements = achievements;
    }

    public String getSteamID() {
        return steamID;
    }

    public void setSteamID(String steamID) {
        this.steamID = steamID;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public boolean success() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<PlayerAchievementsModel> getAchievements() {
        return achievements;
    }

    public void setAchievements(List<PlayerAchievementsModel> achievements) {
        this.achievements = achievements;
    }
}
