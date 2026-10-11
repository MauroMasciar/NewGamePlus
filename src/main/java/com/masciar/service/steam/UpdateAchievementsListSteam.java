package com.masciar.service.steam;

import com.masciar.model.steam.GetPlayerAchievements.PlayerAchievementsModel;
import com.masciar.model.steam.GetSchemaForGame.Achievements;

import java.util.List;

public class UpdateAchievementsListSteam {
    public void update() {
        SteamService ss = new SteamService();
        List<PlayerAchievementsModel> list = ss.getPlayerGameAchievements(1144200);
        List<Achievements> list2 = ss.getAchievementsGame(1144200);
        

        for (int i = 0; i < list.size(); i++) {
            
            
            
            
        }
    }
}
