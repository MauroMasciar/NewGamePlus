package com.masciar.model.steam.GetPlayerAchievements;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerAchievementsModel {
     @JsonProperty("apiname")
    private String apiName;
    private int achieved;
    private int unlocktime;

    public PlayerAchievementsModel() {
    }


    public PlayerAchievementsModel(String apiname, int achieved, int unlocktime) {
        this.apiName = apiname;
        this.achieved = achieved;
        this.unlocktime = unlocktime;
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiname) {
        this.apiName = apiname;
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
