package com.masciar.controller;

import com.masciar.app.Main;
import com.masciar.model.Game;
import com.masciar.service.AddSessionService;
import com.masciar.ui.AddSessionManually;
import com.masciar.ui.MainWindow;

import java.util.Comparator;

public class AddSessionManuallyController {
    AddSessionService addSessionService;
    AddSessionManually view;

    public AddSessionManuallyController(MainWindow window) {
        view = new AddSessionManually(window, true);
        addSessionService = new AddSessionService();
        
        view.setBtnAddListener(e -> add());

        fillComboBoxGames();
        view.setVisible(true);
    }

    public void add() {
        String gameName = view.getGameSelectedString();
        String time = view.getTimeString();
        String date = view.getDateString();
        String hour = view.getHourString();
        boolean success;

        if(Integer.parseInt(time) <= 0) {
            view.showError("El tiempo de juego debe ser mayor a 0");
        } else {
            success = addSessionService.AddSessionManually(gameName, time, date, hour);
            
            if (success) {
                view.showInfo("Sesión de juego añadida");
                view.dispose();
            }
            else
                view.showError("No se ha podido añadir la sesión");
        }
    }

    public void fillComboBoxGames() {
        Main.gameRepository.games_list.sort(Comparator.comparing(Game::getName, String.CASE_INSENSITIVE_ORDER));
		for(Game game : Main.gameRepository.games_list) { 
			view.cbGameAddItem(game.getName());
		}
    }
}
