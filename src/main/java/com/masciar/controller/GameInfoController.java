package com.masciar.controller;

import com.masciar.listener.GameSelectedListener;
import com.masciar.model.Game;
import com.masciar.service.CategoryService;
import com.masciar.service.HistoryService;
import com.masciar.service.LibraryService;
import com.masciar.service.PlatformService;
import com.masciar.ui.MainWindow;
import com.masciar.ui.gameinfo.GameInfo;
import com.masciar.util.DateUtils;
import com.masciar.util.TimeUtils;

public class GameInfoController implements GameSelectedListener {
    private Game gameSelected;
    private GameInfo view;
    private CategoryService categoryService;
    private PlatformService platformService;
    private HistoryService historyService;
    private LibraryService libraryService;

    public GameInfoController(MainWindow window) {
        view = new GameInfo();
        categoryService = new CategoryService();
        platformService = new PlatformService();
        historyService = new HistoryService();
        libraryService = new LibraryService();

        window.add(view);

        view.setBtnEditListener(e -> new EditGameController(window, gameSelected));
    }

    public void update() {
        try {
            view.getSummaryPanel().setGameName(gameSelected.getName());
            view.getSummaryPanel().setLibrary(libraryService.findNameById(gameSelected.getLibrary()));
            view.getSummaryPanel().setCategory(categoryService.findNameById(gameSelected.getCategory()));
            view.getSummaryPanel().setPlatform(platformService.findNameById(gameSelected.getPlatform()));
            view.getSessionPanel().setTotalTimeHoursValue(TimeUtils.getTotalHoursFromSeconds(gameSelected.getTimePlayed(), true));
            view.getSessionPanel().setTotalDaysValue(TimeUtils.getTotalDaysFromSeconds(gameSelected.getTimePlayed()));
            view.getSessionPanel().setTotalSessionsValue(String.valueOf(gameSelected.getPlayCount()));
            if(gameSelected.getTimePlayed() > 0) {
                view.getSessionPanel().setLastSessionDate(DateUtils.formatDateFromString(historyService.getLastSessionFromGame(gameSelected.getId()), 2));
                view.getSessionPanel().setLastSessionTime(TimeUtils.getTotalHoursFromSeconds(historyService.getLastSessionTimeFromGame(gameSelected.getId()), true));
                view.getSessionPanel().setSessionsMonthValue("Este mes: " + String.valueOf(historyService.getCountSessionsLastMonth(gameSelected.getId())));
            } else {
                view.getSessionPanel().setLastSessionDate("Nunca");
                view.getSessionPanel().setLastSessionTime("");
                view.getSessionPanel().setSessionsMonthValue("Este mes: 0");
            }
            view.getSummaryPanel().setCompleted(gameSelected.getCompleted());
            view.pack();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void selectionChanged(Game game) {
        gameSelected = game;
        update();
        view.setVisible(true);
    }

    public Game getGameSelected() {
        return gameSelected;
    }
}
