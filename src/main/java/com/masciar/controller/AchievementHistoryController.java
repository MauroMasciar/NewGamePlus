package com.masciar.controller;

import com.masciar.ui.AchievementsHistory;

import javax.swing.JDesktopPane;



public class AchievementHistoryController {
    AchievementsHistory view;
    public AchievementHistoryController(JDesktopPane desktopPane) {
        view = new AchievementsHistory();
        desktopPane.add(view);
        view.setVisible(true);
    }
}
