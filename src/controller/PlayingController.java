package controller;

import javax.swing.JDesktopPane;
import model.Game;
import service.ChronometerListener;
import service.ChronometerService;
import ui.Chronometer;

public class PlayingController implements ChronometerListener {
    private final Game game;
    private Chronometer view;

    public PlayingController(Game game, JDesktopPane desktopPane) {
        this.game = game;
        
        // Iniciamos vista
        view = new Chronometer(this);
        desktopPane.add(view);

        // Iniciamos listener del cronometro
        ChronometerService ch = new ChronometerService();
        ch.setListener(this);
        ch.start();

        // Cargamos datos a la vista
        view.setGameName(game.getName());
    }

    @Override
    public void timeUpdate(int seconds) {
        view.setTime(seconds);
    }

    @Override
    public void notifyPause() {
        
    }

    @Override
    public void notifyResume() {
        
    }

    @Override
    public void pause() {
        
    }

    @Override
    public void resume() {
        
    }    
}
