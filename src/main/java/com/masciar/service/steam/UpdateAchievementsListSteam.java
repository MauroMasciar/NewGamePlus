package com.masciar.service.steam;

import com.masciar.model.steam.GetOwnedGames.GameModel;
import com.masciar.model.steam.GetPlayerAchievements.PlayerAchievementsModel;
import com.masciar.model.steam.GetSchemaForGame.Achievements;
import com.masciar.service.AchievementService;
import com.masciar.service.GamesService;
import com.masciar.util.DateUtils;

import java.util.List;

public class UpdateAchievementsListSteam {
    public void update() {
        SteamService ss = new SteamService();
        List<GameModel> gameList = ss.getOwnedGames();
        GamesService gamesService = new GamesService();

        for (int i = 0; i < gameList.size(); i++) {
            try {
                AchievementService achievementService = new AchievementService();
                List<Achievements> gameAchievementsList = ss.getAchievementsGame(gameList.get(i).getAppid());
                List<PlayerAchievementsModel> playerAchievementList = ss.getPlayerGameAchievements(gameList.get(i).getAppid());

                for (int b = 0; b < playerAchievementList.size(); b++) {
                    if (playerAchievementList.get(b).getAchieved() == 1) {
                        String apiName = playerAchievementList.get(b).getApiName();
                        int unlockTime = playerAchievementList.get(b).getUnlocktime();

                        Achievements matchedAchievement = null;
                        for (int c = 0; c < gameAchievementsList.size(); c++) {
                            if (apiName.equals(gameAchievementsList.get(c).getName())) {
                                matchedAchievement = gameAchievementsList.get(c);
                                break;
                            }
                        }

                        if (matchedAchievement != null) {
                            String description = matchedAchievement.getDescription();
                            if (description.endsWith(".")) {
                                description = description.substring(0, description.length() - 1);
                            }
                            description = description + " en " + gameList.get(i).getName();
                            achievementService.add(gameList.get(i).getName(), gamesService.findByName(gameList.get(i).getName()).getId(), description, DateUtils.formatUnixDate(unlockTime));
                        }
                    }
                }
            } catch (NullPointerException e) {
                continue;
            }
        }
        System.out.println("listo");
    }
}
