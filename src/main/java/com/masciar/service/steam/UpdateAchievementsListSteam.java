package com.masciar.service.steam;

import com.masciar.app.Main;
import com.masciar.model.steam.GetPlayerAchievements.PlayerAchievementsModel;
import com.masciar.model.steam.GetSchemaForGame.Achievements;
import com.masciar.service.AchievementService;
import com.masciar.service.GamesService;
import com.masciar.util.DateUtils;

import java.util.List;

public class UpdateAchievementsListSteam {
    public void update() {
        SteamService ss = new SteamService();
        GamesService gamesService = new GamesService();

        for (int i = 0; i < Main.gameRepository.games_list.size(); i++) {
            if (Main.gameRepository.games_list.get(i).getAppId() != 0) {
                int appId = Main.gameRepository.games_list.get(i).getAppId();
                String name = Main.gameRepository.games_list.get(i).getName();

                try {
                    AchievementService achievementService = new AchievementService();
                    List<Achievements> gameAchievementsList = ss.getAchievementsGame(appId);
                    List<PlayerAchievementsModel> playerAchievementList = ss.getPlayerGameAchievements(appId);

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
                                description = description + " en " + name;
                                achievementService.add(name, gamesService.findByName(name).getId(), description, DateUtils.formatUnixDate(unlockTime));
                            }
                        }
                    }
                } catch (NullPointerException e) {
                    continue;
                }
            }
        }
    }
}
