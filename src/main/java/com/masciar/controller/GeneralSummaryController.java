package com.masciar.controller;

import com.masciar.ui.GeneralSummaryInternalFrame;
import com.masciar.ui.MainWindow;
import com.masciar.util.Utils;
import com.masciar.service.PlayerService;

public class GeneralSummaryController {
    MainWindow window;
    GeneralSummaryInternalFrame view;
    PlayerService playerService;

    public GeneralSummaryController(MainWindow window) {
        this.window = window;
        view = new GeneralSummaryInternalFrame();
        playerService = new PlayerService();
        window.add(view);

        loadData();
    }

    private void loadData() {
        view.setLblTotalTimeHoursValue(Utils.getTotalHoursFromSeconds(playerService.getTotalTimePlayed(), false));
        view.setlblTotalTimeDaysValue(Utils.getTotalDaysFromSeconds(playerService.getTotalTimePlayed()));
        view.lblTotalGamesStartedValue(String.valueOf(playerService.getTotalStartedGames()));
        view.lblCompletedValue(String.valueOf(playerService.getTotalCompleted()));
        view.lblSessionsValue(String.valueOf(playerService.getTotalSessions()));
    }    
}
