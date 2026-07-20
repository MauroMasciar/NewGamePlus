package controller;

import service.ChronometerListener;
import service.ChronometerService;
import service.PlayingService;
import service.Toast;
import service.AchievementService;
import service.AddSessionService;
import model.Games;
import ui.Chronometer;
import util.Utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JDesktopPane;
import javax.swing.Timer;

public class PlayingController implements ChronometerListener {
    private Games game;
    private Chronometer view;
    private ChronometerService chronometerService;
    private AchievementService achievementService;
    private PlayingService playingService;
    private LocalDateTime startTime = LocalDateTime.now();
    private DateTimeFormatter format_time = DateTimeFormatter.ofPattern("HH:mm");
    private int playedSeconds;
    private Timer timerStrobe;
    private JDesktopPane desktopPane;

    public PlayingController(Games game, JDesktopPane desktopPane) {
        this.game = game;
        this.desktopPane = desktopPane;
        
        // Iniciamos vista
        view = new Chronometer(this);
        desktopPane.add(view);

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
        } catch (Exception ex) {
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
        // TODO: Avisar que no se guardo la sesion si el tiempo de juego es menor a Utils.MINIMUN_SESSION_SECONDS
        chronometerService.stop();
        if(timerStrobe != null) timerStrobe.stop();
        if(playedSeconds > Utils.MINIMUN_SESSION_SECONDS) {
            AddSessionService addSessionService = new AddSessionService();
            addSessionService.addSession(game, startTime, playedSeconds);
        }
        view.dispose();
    }

    @Override
    public void timeUpdate(int playedSeconds, int pausedSeconds) {
        this.playedSeconds = playedSeconds;
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
