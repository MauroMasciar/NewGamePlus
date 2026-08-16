package com.masciar.service;

import com.masciar.dao.HistoryDAO;
import com.masciar.model.Game;

public class HistoryService {
    HistoryDAO historyDAO = new HistoryDAO();

    public void changeName(Game game) {
        historyDAO.changeName(game);
    }

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
        return historyDAO.getLastDays(0, 30);
    }

    public int getTimeLastYear() {
        return historyDAO.getLastDays(0, 365);
    }

    public int getCountSessionsLastMonth(int gameId) {
        return historyDAO.getCountSessionsLastMonth(gameId);
    }
}
