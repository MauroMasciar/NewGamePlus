package com.masciar.service;

import com.masciar.dao.HistoryDAO;

public class HistoryService {
    HistoryDAO historyDAO = new HistoryDAO();

    public String getLastSessionFromGame(int gameId) {
        return historyDAO.getLastSessionFromGame(gameId);
    }

    public int getLastSessionTimeFromGame(int gameId) {
        return historyDAO.getLastSessionTimeFromGame(gameId);
    }

    public int getTimeLastDay() {
        return historyDAO.getLastDays(0, 1);
    }

    public int getTimeLastWeek() {
        return historyDAO.getLastDays(0, 7);
    }

    public int getTimeLastTwoWeek() {
        return historyDAO.getLastDays(0, 14);
    }

    public int getTimeLastMonth() {
        return historyDAO.getLastDays(0, 31);
    }

    public int getTimeLastYear() {
        return historyDAO.getLastDays(0, 365);
    }
}
