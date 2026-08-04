package com.masciar.controller;

import com.masciar.listener.GameSelectedListener;
import com.masciar.model.Games;
import com.masciar.service.CategoryService;
import com.masciar.service.HistoryService;
import com.masciar.service.LibraryService;
import com.masciar.service.PlatformService;
import com.masciar.ui.MainWindow;
import com.masciar.ui.gameinfo.GameInfo;
import com.masciar.util.Utils;

import javax.swing.JDesktopPane;

public class GameInfoController implements GameSelectedListener {
    public Games gameSelected;
    private GameInfo view;
    private CategoryService categoryService;
    private PlatformService platformService;
    private HistoryService historyService;
    private LibraryService libraryService;
    private MainWindow window;

    public GameInfoController(JDesktopPane desktopPane, MainWindow window) {
        view = new GameInfo();
        categoryService = new CategoryService();
        platformService = new PlatformService();
        historyService = new HistoryService();
        libraryService = new LibraryService();

        this.window = window;

        desktopPane.add(view);

        view.setBtnEditListener(e -> editGame());
    }

    @SuppressWarnings("unused")
    private void editGame() {
        EditGameController editGameController = new EditGameController(window, gameSelected);
    }

    public void update() {
        try {
            view.getSummaryPanel().setGameName(gameSelected.getName());
            view.getSummaryPanel().setLibrary(libraryService.findNameById(gameSelected.getLibrary()));
            view.getSummaryPanel().setCategory(categoryService.findNameById(gameSelected.getCategory()));
            view.getSummaryPanel().setPlatform(platformService.findNameById(gameSelected.getPlatform()));
            view.getSessionPanel().setTotalTimeHoursValue(Utils.getTotalHoursFromSeconds(gameSelected.getTimePlayed(), true));
            view.getSessionPanel().setTotalDaysValue(Utils.getTotalDaysFromSeconds(gameSelected.getTimePlayed()));
            view.getSessionPanel().setTotalSessionsValue(String.valueOf(gameSelected.getPlayCount()));
            view.getSessionPanel().setLastSessionDate(Utils.formatDateFromString(historyService.getLastSessionFromGame(gameSelected.getId()), 2));
            view.getSessionPanel().setLastSessionTime(Utils.getTotalHoursFromSeconds(historyService.getLastSessionTimeFromGame(gameSelected.getId()), true));
            view.pack();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void selectionChanged(Games game) {
        gameSelected = game;
        update();
    }
}
