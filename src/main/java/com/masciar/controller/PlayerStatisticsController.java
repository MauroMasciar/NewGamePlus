package com.masciar.controller;

import com.masciar.service.HistoryService;
import com.masciar.ui.PlayerStatistics;
import com.masciar.util.Utils;

import javax.swing.JDesktopPane;

public class PlayerStatisticsController {
    PlayerStatistics playerStatistics = new PlayerStatistics();
    HistoryService historyService = new HistoryService();
    public PlayerStatisticsController(JDesktopPane desktopPane) {
        update();

        desktopPane.add(playerStatistics);
    }

    public void update() {
        String day = Utils.getTotalHoursFromSeconds(historyService.getTimeLastDay(), false);
        String week = Utils.getTotalHoursFromSeconds(historyService.getTimeLastWeek(), false);
        String twoWeek = Utils.getTotalHoursFromSeconds(historyService.getTimeLastTwoWeek(), false);
        String month = Utils.getTotalHoursFromSeconds(historyService.getTimeLastMonth(), false);
        String year = Utils.getTotalHoursFromSeconds(historyService.getTimeLastYear(), false);
        playerStatistics.setInfo(day, week, twoWeek, month, year);
    }
}
