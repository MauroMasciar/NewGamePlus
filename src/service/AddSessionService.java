package service;

import app.Main;
import controller.HistoryController;
import dao.CategoryDAO;
import dao.GamesDAO;
import dao.LibraryDAO;
import dao.PlatformDAO;
import model.Games;
import model.History;
import ui.SessionsHistory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AddSessionService {
    public void AddSessionManually(String gameName, String time, String date_start, String hour_start) {
        GameService gameService = new GameService();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        Games game = gameService.findByName(gameName);

        int seconds = Integer.parseInt(time);
        LocalDateTime dateTimeStart = LocalDateTime.parse(date_start + " " + hour_start + ":00", formatter);
        LocalDateTime dateTimeEnd = dateTimeStart.plusSeconds(Integer.parseInt(time));
        
        saveAll(game, dateTimeStart.toString(), dateTimeEnd.toString(), seconds);
    }

    public void addSession(Games game, LocalDateTime dateTimeStart, int seconds) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTimeEnd = dateTimeStart.plusSeconds(seconds);
        String dateTimeStartFormatted = dateTimeStart.format(formatter);
        String dateTimeEndFormatted = dateTimeEnd.format(formatter);

        saveAll(game, dateTimeStartFormatted, dateTimeEndFormatted, seconds);
    }

    private void saveAll(Games game, String dateTimeStart, String dateTimeEnd, int seconds) {
        History history = new History(Main.achievementsRepository.getList().size() + 1, "NO",  game.getId(), game.getName(), game.getLibrary(), game.getPlatform(), dateTimeStart, dateTimeEnd, seconds);
        saveHistory(history);

        saveGameTime(game, seconds);
        plusLibrary(game, seconds);
        plusCategory(game, seconds);
        plusPlatform(game, seconds);
        plusPlayerTime(seconds);
    }

    private void saveGameTime(Games game, int seconds) {
        game.setTimePlayed(game.getTimePlayed() + seconds);
        game.setPlayCount(game.getPlayCount() + 1);
        GamesDAO gamesDao = new GamesDAO();
        gamesDao.update(game);
    }

    private void saveHistory(History history) {
        Main.historyRepository.getList().add(history);
        HistoryController historyController = new HistoryController();
        historyController.add(history);
        SessionsHistory.updateTableModel();
    }

    private void plusLibrary(Games game, int seconds) {
        for(int i=0; i<Main.librariesRepository.library_list.size(); i++) {
            if(i == game.getLibrary()) {
                int secondsPlayed = Main.librariesRepository.library_list.get(i).getTimePlayed();
                int sessions = Main.librariesRepository.library_list.get(i).getTotalSession();
                Main.librariesRepository.library_list.get(i).setTimePlayed(secondsPlayed + seconds);
                Main.librariesRepository.library_list.get(i).setTotalSession(sessions + 1);
                LibraryDAO libraryDAO = new LibraryDAO();
                libraryDAO.update(i);
            }
        }
    }

    private void plusPlatform(Games game, int seconds) {
        for(int i=0; i<Main.platformsRepository.platforms_list.size(); i++) {
            if(i == game.getPlatform()) {
                int secondsPlayed = Main.platformsRepository.platforms_list.get(i).getTimePlayed();
                int sessions = Main.platformsRepository.platforms_list.get(i).getTotalSessions();
                Main.platformsRepository.platforms_list.get(i).setTimePlayed(secondsPlayed + seconds);
                Main.platformsRepository.platforms_list.get(i).setTotalSessions(sessions + 1);
                PlatformDAO platformDao = new PlatformDAO();
                platformDao.update(i);
            }
        }
    }

    private void plusCategory(Games game, int seconds) {
        for(int i=0; i<Main.categoryRepository.categories_list.size(); i++) {
            if(i == game.getCategory()) {
                int secondsPlayed = Main.categoryRepository.categories_list.get(i).getTimePlayed();
                int sessions = Main.categoryRepository.categories_list.get(i).getTotalSessions();
                Main.categoryRepository.categories_list.get(i).setTimePlayed(secondsPlayed + seconds);
                Main.categoryRepository.categories_list.get(i).setTotalSessions(sessions + 1);
                CategoryDAO categoryDao = new CategoryDAO();
                categoryDao.update(i);
            }
        }
    }

    private void plusPlayerTime(int seconds) {
        int secondsPlayed = Main.playerRepository.players_list.get(0).getTotalTime();
        int sessions = Main.playerRepository.players_list.get(0).getTotalSessions();
        Main.playerRepository.players_list.get(0).setTotalTime(secondsPlayed + seconds);
        Main.playerRepository.players_list.get(0).setTotalSessions(sessions + 1);
    }
}
