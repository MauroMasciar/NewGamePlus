package com.masciar.controller;

import com.masciar.service.HistoryService;
import com.masciar.ui.PlayerStatistics;
import com.masciar.util.TimeUtils;

import javax.swing.JDesktopPane;

public class PlayerStatisticsController {
    PlayerStatistics playerStatistics = new PlayerStatistics();
    HistoryService historyService = new HistoryService();
    public PlayerStatisticsController(JDesktopPane desktopPane) {
        update();

        desktopPane.add(playerStatistics);
    }

    public void update() {
        String day = TimeUtils.getTotalHoursFromSeconds(historyService.getTimeLastDay(), false);
        String week = TimeUtils.getTotalHoursFromSeconds(historyService.getTimeLastWeek(), false);
        String twoWeek = TimeUtils.getTotalHoursFromSeconds(historyService.getTimeLastTwoWeek(), false);
        String month = TimeUtils.getTotalHoursFromSeconds(historyService.getTimeLastMonth(), false);
        String year = TimeUtils.getTotalHoursFromSeconds(historyService.getTimeLastYear(), false);
        playerStatistics.setInfo(day, week, twoWeek, month, year);
    }
}
