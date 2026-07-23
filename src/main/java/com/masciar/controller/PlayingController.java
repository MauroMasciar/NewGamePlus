package com.masciar.controller;

import com.masciar.service.ChronometerService;
import com.masciar.service.PlayingService;
import com.masciar.service.Toast;
import com.masciar.service.AchievementService;
import com.masciar.service.AddSessionService;
import com.masciar.listener.ChronometerListener;
import com.masciar.model.Games;
import com.masciar.ui.ChronometerInternalFrame;
import com.masciar.util.Utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JDesktopPane;
import javax.swing.Timer;

public class PlayingController implements ChronometerListener {
    private Games game;
    private ChronometerInternalFrame view;
    private ChronometerService chronometerService;
    private AchievementService achievementService;
    private PlayingService playingService;
    private LocalDateTime startTime = LocalDateTime.now();
    private DateTimeFormatter format_time = DateTimeFormatter.ofPattern("HH:mm");
    private int playedSeconds;
    private int pausedSeconds;
    private Timer timerStrobe;
    private JDesktopPane desktopPane;

    public PlayingController(Games game, JDesktopPane desktopPane) {
        this.game = game;
        this.desktopPane = desktopPane;
        
        // Iniciamos vista
        view = new ChronometerInternalFrame();
        desktopPane.add(view);
        view.toFront();

        // Iniciamos listener del cronometro
        chronometerService = new ChronometerService();
        chronometerService.setListener(this);
        chronometerService.start();

        // Instanciamos services
        achievementService = new AchievementService(game);
        playingService = new PlayingService();

        // Cargamos datos a la vista
        view.setGameName(game.getName());
        view.setPlayCount(String.valueOf(game.getPlayCount()));
        view.setTotalPlayed(Utils.getTotalHoursFromSeconds(game.getTimePlayed(), true));
        view.setTotalPlayedAfterSession(Utils.getTotalHoursFromSeconds(game.getTimePlayed(), false));
        view.setAgeSession("Iniciado a las " + startTime.format(format_time) + " hace " + Utils.getTotalHoursFromSeconds(0, false));
        try {
            view.setAvgTimePlayed(Utils.getTotalHoursFromSeconds(game.getTimePlayed() / game.getPlayCount(), false));
        } catch (Exception e) {
            view.setAvgTimePlayed("00h 00m");
        }
        
        timerStrobe = new Timer(500, e -> view.strobe(chronometerService.isPaused()));

        // Asignamos listener a los componentes
        view.setBtnPauseListener(e -> pauseSession());
        view.setBtnStopListener(e -> endSession());

        Toast.showToast(desktopPane, "Juego lanzado");
    }

    public void pauseSession() {
        if(chronometerService.isPaused()) {
            chronometerService.setPaused(false);
            view.btnPauseText("Pausar");
            Toast.showToast(desktopPane, "Cronómetro corriendo");
            if(timerStrobe != null) timerStrobe.stop();
        } else {
            chronometerService.setPaused(true);
            view.setPauseCount(String.valueOf(chronometerService.getPauseCount()));
            view.btnPauseText("Reanudar");
            Toast.showToast(desktopPane, "Cronómetro en pausa");
            timerStrobe.start();
        }
        view.strobe(chronometerService.isPaused());
    }

    public void endSession() {
        chronometerService.stop();
        if(timerStrobe != null) timerStrobe.stop();
        view.dispose();
        if(playedSeconds > Utils.MINIMUN_SESSION_SECONDS) {
            AddSessionService addSessionService = new AddSessionService();
            addSessionService.addSession(game, startTime, playedSeconds, pausedSeconds);
        } else {
            view.showError("El tiempo de juego ha sido muy corto y no se ha guardado");
        }
        view.dispose();
    }

    @Override
    public void timeUpdate(int playedSeconds, int pausedSeconds) {
        this.playedSeconds = playedSeconds;
        this.pausedSeconds = pausedSeconds;
        view.setTime(Utils.getTotalHoursFromSeconds(playedSeconds, true));
        view.setTimePaused(Utils.getTotalHoursFromSeconds(pausedSeconds, true));
        view.setTimeTotal(Utils.getTotalHoursFromSeconds(pausedSeconds + playedSeconds, true));
        achievementService.checkInGame(playedSeconds);
    }

    @Override
    public void notifyMinuteElapsed(int seconds) {
        view.setTotalFutureTime(Utils.getTotalHoursFromSeconds(game.getTimePlayed() + seconds, false));
        view.setAgeSession("Iniciado a las " + startTime.format(format_time) + " hace " + Utils.getTotalHoursFromSeconds(seconds, false));
        playingService.saveBackup(game.getId(), startTime.toString(), seconds);
    }
}
