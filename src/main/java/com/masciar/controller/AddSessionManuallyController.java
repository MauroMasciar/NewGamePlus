package com.masciar.controller;

import com.masciar.app.Main;
import com.masciar.model.Games;
import com.masciar.service.AddSessionService;
import com.masciar.ui.AddSessionManuallyDialog;
import com.masciar.ui.MainWindow;

import java.util.Comparator;

public class AddSessionManuallyController {
    AddSessionService addSessionService;
    AddSessionManuallyDialog view;

    public AddSessionManuallyController(MainWindow window) {
        view = new AddSessionManuallyDialog(window, true);
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

        if(Integer.parseInt(time) <= 0) {
            view.showError("El tiempo de juego debe ser mayor a 0");
        } else {
            addSessionService.AddSessionManually(gameName, time, date, hour);
            view.showInfo("Sesión de juego añadida");
            view.dispose();
        }
    }

    public void fillComboBoxGames() {
        Main.gameRepository.games_list.sort(Comparator.comparing(Games::getName, String.CASE_INSENSITIVE_ORDER));
		for(Games game : Main.gameRepository.games_list) { 
			view.cbGameAddItem(game.getName());
		}
    }
}
