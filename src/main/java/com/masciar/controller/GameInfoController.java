package com.masciar.controller;

import javax.swing.JDesktopPane;

import com.masciar.listener.GameSelectedListener;
import com.masciar.model.Games;
import com.masciar.service.CategoryService;
import com.masciar.service.HistoryService;
import com.masciar.service.LibraryService;
import com.masciar.service.PlatformService;
import com.masciar.ui.GameInfo;
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
        view.setGameName(gameSelected.getName());
        view.setLibrary(libraryService.findNameById(gameSelected.getLibrary()));
        view.setCategory(categoryService.findNameById(gameSelected.getCategory()));
        view.setPlatform(platformService.findNameById(gameSelected.getPlatform()));
        view.setTotalTimeHoursValue(Utils.getTotalHoursFromSeconds(gameSelected.getTimePlayed(), true));
        view.setTotalDaysValue(Utils.getTotalDaysFromSeconds(gameSelected.getTimePlayed()));
        view.setTotalSessionsValue(String.valueOf(gameSelected.getPlayCount()));
        view.setLastSessionValue(historyService.getLastSessionFromGame(gameSelected.getId()));
        view.setLastSessionTimeValue(String.valueOf(historyService.getLastSessionTimeFromGame(gameSelected.getId())));
        view.pack();
    }

    @Override
    public void selectionChanged(Games game) {
        gameSelected = game;
        Update();
    }
}
