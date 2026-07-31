package com.masciar.controller;

import javax.swing.JDesktopPane;

import com.masciar.listener.GameSelectedListener;
import com.masciar.model.Games;
import com.masciar.service.CategoryService;
import com.masciar.service.HistoryService;
import com.masciar.service.LibraryService;
import com.masciar.service.PlatformService;
import com.masciar.ui.gameinfo.GameInfo;
import com.masciar.util.Utils;

public class GameInfoController implements GameSelectedListener {
    private Games gameSelected;
    private GameInfo view;
    private CategoryService categoryService;
    private PlatformService platformService;
    private HistoryService historyService;
    private LibraryService libraryService;

    public GameInfoController(JDesktopPane desktopPane) {
        view = new GameInfo();
        categoryService = new CategoryService();
        platformService = new PlatformService();
        historyService = new HistoryService();
        libraryService = new LibraryService();
        desktopPane.add(view);
    }

    public void Update() {
        try {
            view.getSummaryPanel().setGameName(gameSelected.getName());
            view.getSummaryPanel().setLibrary(libraryService.findNameById(gameSelected.getLibrary()));
            view.getSummaryPanel().setCategory(categoryService.findNameById(gameSelected.getCategory()));
            view.getSummaryPanel().setPlatform(platformService.findNameById(gameSelected.getPlatform()));
            view.getSessionPanel().setTotalTimeHoursValue(Utils.getTotalHoursFromSeconds(gameSelected.getTimePlayed(), true));
            view.getSessionPanel().setTotalDaysValue(Utils.getTotalDaysFromSeconds(gameSelected.getTimePlayed()));
            view.getSessionPanel().setTotalSessionsValue(String.valueOf(gameSelected.getPlayCount()));
            view.getSessionPanel().setLastSessionDate(historyService.getLastSessionFromGame(gameSelected.getId()));
            view.getSessionPanel().setLastSessionTime(Utils.getTotalHoursFromSeconds(historyService.getLastSessionTimeFromGame(gameSelected.getId()), true));
            view.pack();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void selectionChanged(Games game) {
        gameSelected = game;
        Update();
    }

}
