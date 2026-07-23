package com.masciar.service;

import com.masciar.app.Main;
import com.masciar.dao.GamesDAO;
import com.masciar.model.Games;
import com.masciar.ui.AddGameDialog;
import com.masciar.util.Utils;

public class GameService {
    private AddGameDialog view;
    private AchievementService achievementService;

    public GameService() { }
    
    public GameService(AddGameDialog view, AchievementService achievementService) {
        this.achievementService = achievementService;
        this.view = view;
    }

    public boolean saveData() {
        int hide = 0, favorite = 0, statistic = 0, portable = 0, completed = 0, play_count = 0;

        if(view.getFavoriteState()) favorite = 1;
        if(view.getCompletedState()) completed = 1;
        if(view.getStatisticState()) statistic = 1;
        if(view.getPortableState()) portable = 1;
        if(view.getHideState()) hide = 1;

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
        String image = "";

        name = name.replace("'", "");
        name = name.replace("\"", "");

        if(releasedate.isEmpty()) releasedate = "1900-01-01";
        if(rating.isEmpty()) rating = "PR - Pending Rate";
        if(developer.isEmpty()) developer = "N/A";
        if(publisher.isEmpty()) publisher = "N/A";
        if(series.isEmpty()) series = "N/A";
        if(region.isEmpty()) region = "N/A";
        if(playMode.isEmpty()) playMode = "N/A";
        if(version.isEmpty()) version = "N/A";
        if(status.isEmpty()) status = "N/A";
        if(lastPlayed.isEmpty()) lastPlayed = "1900-01-01";
        if(path.isEmpty()) path = "N/A";
        if(completed_date.isEmpty()) completed_date = "1900-01-01";
        if(notes.isEmpty()) notes = "";

        if(name.isEmpty()) {
            return false;
        } else {
            int id = Main.gameRepository.getList().size() + 1;
            Games game = new Games(id, name, category, library, score, gameTime, play_count, completed, completed_date, hide, path, releasedate,
				developer, series, playMode, status, lastPlayed, rating, platform, publisher, region, version, added, modified, favorite, statistic, 
                portable, image, notes);
            GamesDAO gamesDao = new GamesDAO();
            if(gamesDao.add(game)) {
                Main.gameRepository.games_list.add(game);
                achievementService.createGameObtainedAchievement(game);
                view.dispose();
                return true;
            } else return false;
        }
    }

    public Games findById(int id) {
        for (Games game : Main.gameRepository.games_list) {
            if(game.getId() == id) return game;
        }
        return null;
    }

    public Games findByName(String name) {
        for (Games game : Main.gameRepository.games_list) {
            if(game.getName().equals(name)) return game;
        }
        return null;
    }
}
