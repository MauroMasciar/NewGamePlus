package ui;

import util.Utils;
import service.ConfigService;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.awt.event.ActionEvent;



public class Chronometer extends JFrame implements ActionListener {
	private static final long serialVersionUID = 3054154723097695816L;
	private static final int SECONDS_PER_HOUR = 3600;
	private String user_id = ConfigService.getProperty("user_id");
	private String userName = ConfigService.getProperty("name");
	private String gameName;
	private int minutesTotalPlayed = 0;
	private int current_session_number = 0;
	private int totalSeconds = 0;
	private int secondsBeetwenTimes = 0;
	private int pauses = 0;
	private int totalSecondsPause = 0;
	private int secondsBeetwenTimesPause = 0;
	private int totalPlaying;
	private int totalPause = 0;
	private int gameTimePlayedTotal = 0;
	private boolean run = false;
	private boolean pause = false;
	private String startTime = Utils.getFormattedDateTime();
	private LocalDateTime initTime;
	private LocalDateTime initPauseTime;
	private int gameId;
	private JLabel lblSeparator = new JLabel("_____________________________________________");
	private JLabel lblSeparator2 = new JLabel("_____________________________________________");
	private JLabel lblSeparator3 = new JLabel("_____________________________________________");
	private JLabel lblGameName = new JLabel("Nombre del juego");
	private JLabel lblSessionStatus = new JLabel("\u25CF Sesión activa");
	private JLabel lblTime = new JLabel("00:00:00");
	private JLabel lblInfoTime = new JLabel("Tiempo jugado efectivo");
	private JLabel lblInitDate = new JLabel("Iniciado a las 00:00 hace 0h 0m");
	private JButton btnPause = new JButton("Pausar");
	private JButton btnStop = new JButton("Finalizar sesión");
	private JLabel lblStats = new JLabel("ESTADÍSTICAS DE LA SESIÓN");
	private JLabel lblPauses = new JLabel("Pausas");
	private JLabel lblPausesValue = new JLabel("0");
	private JLabel lblPauseTime = new JLabel("Tiempo en pausa");
	private JLabel lblPauseTimeValue = new JLabel("0h 00m 00s");
	private JLabel lblTotalTime = new JLabel("Tiempo total");
	private JLabel lblTotalTimeValue = new JLabel("00:00:00");
	private JLabel lblMedTimeSession = new JLabel("Media por sesión");
	private JLabel lblMedTimeSessionValue = new JLabel("00:00:00");
	private JLabel lblTotalPlayedGame = new JLabel("Tiempo total jugado");
	private JLabel lblTotalPlayedGameValue = new JLabel("00:00");
	private JLabel lblPlayCount = new JLabel("Veces iniciado");
	private JLabel lblPlayCountValue = new JLabel("0");	
	private JLabel lblInfoFuture = new JLabel("Con esta sesión llegarás a");
	private JLabel lblInfoFutureTime = new JLabel("0h 0m");
	private JLabel lblInfoFutureFooter = new JLabel("tiempo total jugado");
    public Chronometer() {
    	
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
