package com.masciar.controller;

import com.masciar.ui.GeneralSummary;
import com.masciar.util.Utils;
import javax.swing.JDesktopPane;
import com.masciar.service.PlayerService;

public class GeneralSummaryController {
    GeneralSummary view;
    PlayerService playerService;

    public GeneralSummaryController(JDesktopPane desktopPane) {
        view = new GeneralSummary();
        playerService = new PlayerService();
        desktopPane.add(view);

        refresh();
    }

    public void refresh() {
        view.setLblTotalTimeHoursValue(Utils.getTotalHoursFromSeconds(playerService.getTotalTimePlayed(), false));
        view.setlblTotalTimeDaysValue(Utils.getTotalDaysFromSeconds(playerService.getTotalTimePlayed()));
        view.setLblTotalGamesStartedValue(String.valueOf(playerService.getTotalStartedGames()));
        view.setLblCompletedValue(String.valueOf(playerService.getTotalCompleted()));
        view.setLblSessionsValue(String.valueOf(playerService.getTotalSessions()));
    }
}
