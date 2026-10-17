package com.masciar.service;

import com.masciar.dao.AchievementDAO;
import com.masciar.model.Achievement;
import com.masciar.model.Game;
import com.masciar.ui.MainWindow;
import com.masciar.util.DateUtils;
import com.masciar.util.TimeUtils;
import com.masciar.util.Utils;
import com.masciar.app.Main;

import java.util.Comparator;
import java.util.List;

public class AchievementService {
    private PlayerService playerService;
    private LibraryService libraryService;
    private Game game;
    private AchievementDAO achievementDAO = new AchievementDAO();

    public AchievementService() {
    }

    public AchievementService(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    public AchievementService(Game game) {
        this.game = game;
        playerService = new PlayerService();
    }

    public void changeName(Game game) {
        achievementDAO.changeName(game);
    }

    public void checkInGame(int playedSeconds) {
        String achievement = "";

        if (game.getTimePlayed() + playedSeconds == 310) {
            achievement = "Has jugado a " + game.getName() + " por primera vez";
            add(game.getName(), game.getId(), achievement, DateUtils.getFormattedDateTime());
        }

        achievement = "";
        
        int totalPlayedSeconds = game.getTimePlayed() + playedSeconds;

        int[] milestones = {
                1, 5, 10, 25, 50, 100, 250, 500,
                1000, 2000, 5000, 7500, 10000
        };

        for (int hours : milestones) {
            if (totalPlayedSeconds == Utils.SECONDS_PER_HOUR * hours) {
                achievement = "Has alcanzado " + (hours == 1 ? "tu primera hora" : hours + " horas") + " de juego en " + game.getName();
                add(game.getName(), game.getId(), achievement, DateUtils.getFormattedDateTime());
                break;
            }
        }

        achievement = "";

        int totalSecondsPlayed = playedSeconds + playerService.getTotalTimePlayed();

        if (totalSecondsPlayed % 60 == 0) {
            for (int hours : milestones) {
                if (totalSecondsPlayed == Utils.SECONDS_PER_HOUR * hours) {
                    achievement = hours == 1
                            ? "Has alcanzado tu primera hora de juego en total"
                            : "Has alcanzado " + hours + " horas de juego en total";
                    break;
                }
            }

            if (!achievement.isEmpty()) {
                add(game.getName(), game.getId(), achievement, DateUtils.getFormattedDateTime());
            }
        }
    }

    public void createGameObtainedAchievement(Game game) {
        String text = "Obtuviste " + game.getName() + " en " + libraryService.findNameById(game.getLibrary());
        add(game.getName(), game.getId(), text, DateUtils.getFormattedDateTime());
    }

    public void createCompletedGameAchievement(Game game) {
        List<Achievement> list = Main.achievementsRepository.achievementsList;
        boolean completed = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getGameId() == game.getId()) {
                if (list.get(i).getDescription().contains("Has terminado el juego")) {
                    completed = true;
                    break;
                }
            }
        }
        if (!completed) {
            String text = "Has terminado el juego " + game.getName() + " en " + TimeUtils.getTotalHoursFromSeconds(game.getTimePlayed(), false);
            add(game.getName(), game.getId(), text, game.getCompletedDate() + " " + TimeUtils.getFormattedTime());
        }
    }
    

    public void add(String name, int gameId, String description, String date) {
        if (!achievementExists(description)) {
            Achievement achievement = new Achievement(0, name, gameId, description, date);
            AchievementDAO achievementDAO = new AchievementDAO();
            int id = achievementDAO.add(achievement);
            if (id != 0) {
                achievement.setId(id);
                Main.achievementsRepository.getList().add(achievement);
                MainWindow.refreshOpenViews();
            } else {
                for (int i = 0; i < Main.achievementsRepository.achievementsList.size(); i++) {
                    if (Main.achievementsRepository.achievementsList.get(i).getDescription().equals(description)) {
                        Main.achievementsRepository.achievementsList.remove(i);
                        break;
                    }
                }
            }
        }
    }

    public String getLastAchievement() {
        List<Achievement> list = Main.achievementsRepository.getList().stream().sorted(Comparator.comparing(Achievement::getDate).reversed()).toList();
        try {
            return list.getFirst().getDescription() + " (" +
                    DateUtils.formatDateFromString(list.getFirst().getDate(), 2) + " " +
                    DateUtils.formatDateFromString(list.getFirst().getDate(), 5) + ")";
        } catch (java.util.NoSuchElementException ex) {
            return "";
        }
    }

    private boolean achievementExists(String description) {
        for (int i = 0; i < Main.achievementsRepository.achievementsList.size(); i++) {
            if (Main.achievementsRepository.achievementsList.get(i).getDescription().equals(description)) {
                return true;
            }
        }
        return false;
    }
}
