package com.masciar.model.steam.GetPlayerAchievements;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerAchievementsModel {
    private String apiname;
    private int achieved;
    private int unlocktime;

    public PlayerAchievementsModel(String apiname, int achieved, int unlocktime) {
        this.apiname = apiname;
        this.achieved = achieved;
        this.unlocktime = unlocktime;
    }

    public String getApiname() {
        return apiname;
    }

    public void setApiname(String apiname) {
        this.apiname = apiname;
    }

    public int getAchieved() {
        return achieved;
    }

    public void setAchieved(int achieved) {
        this.achieved = achieved;
    }

    public int getUnlocktime() {
        return unlocktime;
    }

    public void setUnlocktime(int unlocktime) {
        this.unlocktime = unlocktime;
    }
}
