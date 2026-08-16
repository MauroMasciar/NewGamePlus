package com.masciar.controller;

import com.masciar.app.Main;
import com.masciar.model.Category;
import com.masciar.model.Game;
import com.masciar.model.Library;
import com.masciar.model.Platform;
import com.masciar.service.CategoryService;
import com.masciar.service.GameService;
import com.masciar.service.HistoryService;
import com.masciar.service.LibraryService;
import com.masciar.service.PlatformService;
import com.masciar.ui.AddGame;
import com.masciar.ui.MainWindow;
import com.masciar.util.DateUtils;
import com.masciar.util.TimeUtils;

public class EditGameController {
    private AddGame view;
    private Game game;

    public EditGameController(MainWindow window, Game game) {
        view = new AddGame(window, game, true);
        this.game = game;
        
        loadCategories();
        loadLibraries();
        loadPlatforms();
        loadGameData();

        view.pack();

        view.showPopupCompletedDateListener(e -> showPopupCompletedDate());
        view.showPopupReleaseDateListener(e -> showPopupReleaseDate());
        view.setBtnSaveListener(e -> saveGame());
        view.setSpinGameTimeListener(e -> setSpinGameTimer());

        view.setVisible(true);
    }

    public void loadCategories() {
        for(Category category : Main.categoryRepository.categories_list) {
            view.fillComboBoxCategory(category.getName());
        }
    }

    public void loadLibraries() {
        for(Library library : Main.librariesRepository.library_list) {
            view.fillComboBoxLibrary(library.getName());
        }
    }

    public void loadPlatforms() {
        for(Platform platforms : Main.platformsRepository.platforms_list) {
            view.filLComboBoxPlatform(platforms.getName());
        }
    }

    public void showPopupCompletedDate() {
        view.showPopupCompletedDate();
    }

    public void showPopupReleaseDate() {
        view.showPopupReleaseDate();
    }

    public void setSpinGameTimer() {
        String string = "(" + TimeUtils.getTotalHoursFromSeconds(view.getSpinGameTimeValue(), true) + ")";
        view.setLblConvertedSeconds(string);
    }

    private void loadGameData() {
        for(Category c : Main.categoryRepository.categories_list) {
            if(c.getId() == game.getCategory()) view.setCbCategory(c.getName());
        }

        for(Library l : Main.librariesRepository.library_list) {
            if(l.getId() == game.getLibrary()) view.setCbLibrary(l.getName());
        }

        for(Platform p : Main.platformsRepository.platforms_list) {
            if(p.getId() == game.getPlatform()) view.setCbPlatform(p.getName());
        }

        view.setCbRating(game.getRating());
        view.setTxtGameName(game.getName());
        view.setSpinScore(game.getScore());
        view.setSpinTime(game.getTimePlayed());
        view.setSpinPlayCount(game.getPlayCount());
        view.setCompletedDate(game.getCompletedDate());
        view.setTxtPath(game.getPath());
        view.setReleaseDate(game.getReleaseDate());
        view.setTxtDeveloper(game.getDeveloper());
        view.setTxtSeries(game.getSeries());
        view.setTxtPlayMode(game.getPlayMode());
        view.setTxtStatus(game.getStatus());
        view.setTxtLastPlayed(game.getLastPlayed());
        view.setTxtPublisher(game.getPublisher());
        view.setTxtRegion(game.getRegion());
        view.setTxtVersion(game.getVersion());
        view.setDateAddded(game.getAdded());
        view.setDateModified(game.getModified());
        view.setTxtaNotes(game.getNotes());

        if(game.getFavorite() == 1)
            view.setCheckFavorite(true);
        else
            view.setCheckFavorite(false);

        if(game.getStatistic() == 1)
            view.setCheckStatistic(true);
        else
            view.setCheckStatistic(false);

        if(game.getPortable() == 1)
            view.setCheckPortable(true);
        else
            view.setCheckPortable(false);

        if(game.getCompleted() == 1)
            view.setCheckCompleted(true);
        else
            view.setCheckCompleted(false);

        if(game.getCompleted() == 1) 
            view.setCompletedDate(game.getCompletedDate());
        else
            view.setCompletedDate(DateUtils.getFormattedDate());

        if(game.getHidden() == 1)
            view.setCheckHidden(true);
        else
            view.setCheckHidden(false);
        
        String string = "(" + TimeUtils.getTotalHoursFromSeconds(view.getSpinGameTimeValue(), true) + ")";
        view.setLblConvertedSeconds(string);
    }

    private void saveGame() {
        CategoryService categoryService = new CategoryService();
        LibraryService libraryService = new LibraryService();
        PlatformService platformService = new PlatformService();

        game.setCategory(categoryService.findIdByName(view.getCbCategoryString()));
        game.setLibrary(libraryService.findIdByName(view.getCbLibraryString()));
        game.setPlatform(platformService.findIdByName(view.getCbPlatformString()));
        game.setRating(view.getRatingValueString());
        game.setName(view.getTxtNameString());
        game.setScore(view.getSpinScoreValue());
        game.setPlayCount(view.getSpinPlayCount());
        game.setCompletedDate(view.getTxtCompletedDateString());
        game.setPath(view.getTxtPath());
        game.setReleaseDate(view.getDateRelease());
        game.setDeveloper(view.getTxtDeveloper());
        game.setSeries(view.getTxtSeries());
        game.setPlayMode(view.getTxtPlayMode());
        game.setStatus(view.getTxtStatus());
        game.setLastPlayed(view.getTxtLastPlayed());
        game.setPublisher(view.getTxtPublisher());
        game.setRegion(view.getTxtRegion());
        game.setVersion(view.getTxtVersion());
        game.setAdded(view.getDateAdded());
        game.setModified(view.getDateModified());
        game.setTimePlayed(view.getSpinGameTimeValue());
        game.setNotes(view.getTxtaNotes());

        if(view.getCompletedState()) 
            game.setCompleted(1);
        else 
            game.setCompleted((0));

        if(view.getHidden()) 
            game.setHidden(1);
        else 
            game.setHidden((0));

        if(view.getFavoriteState())
            game.setFavorite(1);
        else
            game.setFavorite(0);

        if(view.getStatisticState()) 
            game.setStatistic(1);
        else
            game.setStatistic(0);

        if(view.getPortableState())
            game.setPortable(1);
        else
            game.setPortable(0);

        view.setTxtaNotes(game.getNotes());

        String string = "(" + TimeUtils.getTotalHoursFromSeconds(view.getSpinGameTimeValue(), true) + ")";
        view.setLblConvertedSeconds(string);

        GameService gameService = new GameService();
        gameService.saveGame(game);

        HistoryService historyService = new HistoryService();
        historyService.changeName(game);

        MainWindow.refreshOpenViews();
        view.dispose();
    }
}
