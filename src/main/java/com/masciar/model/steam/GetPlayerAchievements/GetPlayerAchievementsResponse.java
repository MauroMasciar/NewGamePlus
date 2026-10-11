package com.masciar.model.steam.GetPlayerAchievements;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetPlayerAchievementsResponse {
    private GetOwnerAchievementsData playerstats;

    public GetPlayerAchievementsResponse() {
    }

    public GetOwnerAchievementsData getPlayerstats() {
        return playerstats;
    }

    public void setPlayerstats(GetOwnerAchievementsData playerstats) {
        this.playerstats = playerstats;
    }
}
