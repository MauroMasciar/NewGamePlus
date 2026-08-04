package com.masciar.service;

import com.masciar.app.Main;
import com.masciar.dao.GamesDAO;
import com.masciar.model.Games;
import com.masciar.ui.AddGame;
import com.masciar.util.Utils;

import java.util.Comparator;

import javax.swing.DefaultListModel;

public class GameService {
    private AddGame view;
    private AchievementService achievementService;

    public GameService() {
    }

    public GameService(AddGame view, AchievementService achievementService) {
        this.achievementService = achievementService;
        this.view = view;
    }

    public boolean addGame() {
        int hide = 0, favorite = 0, statistic = 0, portable = 0, completed = 0;

        if (view.getFavoriteState())
            favorite = 1;
        if (view.getCompletedState())
            completed = 1;
        if (view.getStatisticState())
            statistic = 1;
        if (view.getPortableState())
            portable = 1;
        if (view.getHideState())
            hide = 1;

        PlatformService ps = new PlatformService();
        LibraryService ls = new LibraryService();
        CategoryService cs = new CategoryService();

        String releasedate = view.getTxtReleaseDate();
        String rating = view.getRatingValueString();
        int platform = ps.findIdByName(view.getCbPlatformString());
        String developer = view.getTxtDeveloper();
        String publisher = view.getTxtPublisher();
        String series = view.getTxtSeries();
        String region = view.getTxtRegion();
        String playMode = view.getTxtPlayMode();
        String version = view.getTxtVersion();
        String status = view.getTxtStatus();
        int library = ls.findIdByName(view.getCbLibraryString());
        String lastPlayed = view.getTxtLastPlayed();
        String path = view.getTxtPath();
        String name = view.getTxtNameString();
        String added = Utils.getFormattedDate();
        String modified = Utils.getFormattedDateTime();
        String completed_date = view.getTxtCompletedDateString();
        String notes = view.getTxtaNotes();
        int score = view.getSpinScoreValue();
        int gameTime = (Integer) view.getSpinGameTimeValue();
        int category = cs.findIdByName(view.getCbCategoryString());
        int playCount = 0;
        String image = "";

        name = name.replace("'", "");
        name = name.replace("\"", "");

        if (releasedate.isEmpty())
            releasedate = "1900-01-01";
        if (rating.isEmpty())
            rating = "PR - Pending Rate";
        if (developer.isEmpty())
            developer = "N/A";
        if (publisher.isEmpty())
            publisher = "N/A";
        if (series.isEmpty())
            series = "N/A";
        if (region.isEmpty())
            region = "N/A";
        if (playMode.isEmpty())
            playMode = "N/A";
        if (version.isEmpty())
            version = "N/A";
        if (status.isEmpty())
            status = "N/A";
        if (lastPlayed.isEmpty())
            lastPlayed = "1900-01-01";
        if (path.isEmpty())
            path = "N/A";
        if (completed_date.isEmpty())
            completed_date = "1900-01-01";
        if (notes.isEmpty())
            notes = "";
        
        int appId = 0;

        if (name.isEmpty()) {
            return false;
        } else {
            int id = Main.gameRepository.getList().size() + 1;
            Games game = new Games(id, name, category, library, score, gameTime, playCount, completed, completed_date,
                    hide, path, releasedate,
                    developer, series, playMode, status, lastPlayed, rating, platform, publisher, region, version,
                    added, modified, favorite, statistic,
                    portable, image, notes, appId);
            GamesDAO gamesDao = new GamesDAO();
            if (gamesDao.add(game)) {
                Main.gameRepository.games_list.add(game);
                achievementService.createGameObtainedAchievement(game);
                view.dispose();
                return true;
            } else
                return false;
        }
    }

    public void saveGame(Games game) {
        GamesDAO gamesDao = new GamesDAO();
        gamesDao.update(game);
    }

    public Games findById(int id) {
        for (Games game : Main.gameRepository.games_list) {
            if (game.getId() == id)
                return game;
        }
        return null;
    }

    public Games findByName(String name) {
        for (Games game : Main.gameRepository.games_list) {
            if (game.getName().equals(name))
                return game;
        }
        return null;
    }

    public DefaultListModel<Games> searchGameModel(String name) {
        DefaultListModel<Games> model = new DefaultListModel<>();
        Main.gameRepository.games_list.sort(Comparator.comparing(Games::getName, String.CASE_INSENSITIVE_ORDER));
        for (Games game : Main.gameRepository.games_list) {
            if (game.getName().toLowerCase().contains(name)) {
                model.addElement(game);
            }                
        }
        return model;
    }
}
