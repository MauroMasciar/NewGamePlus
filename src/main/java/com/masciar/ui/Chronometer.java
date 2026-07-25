package com.masciar.ui;

import com.masciar.util.RoundedBorder;
import com.masciar.util.Utils;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

public class Chronometer extends JInternalFrame {
    private JLabel lblSeparator = new JLabel("____________________________________________________");
    private JLabel lblSeparator2 = new JLabel("____________________________________________________");
    private JLabel lblSeparator3 = new JLabel("____________________________________________________");
    private JLabel lblGameName = new JLabel("Nombre del juego");
    private JLabel lblSessionStatus = new JLabel("\u25CF Sesión activa");
    private JLabel lblTime = new JLabel("0h 00m 00s");
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
    private JLabel lblTotalTimeValue = new JLabel("0h 00m 00s");
    private JLabel lblMedTimeSession = new JLabel("Media por sesión");
    private JLabel lblMedTimeSessionValue = new JLabel("0h 00m 00s");
    private JLabel lblTotalPlayedGame = new JLabel("Tiempo total jugado");
    private JLabel lblTotalPlayedGameValue = new JLabel("00:00");
    private JLabel lblPlayCount = new JLabel("Veces iniciado");
    private JLabel lblPlayCountValue = new JLabel("0");
    private JLabel lblInfoFuture = new JLabel("Con esta sesión llegarás a");
    private JLabel lblInfoFutureTime = new JLabel("0h 0m");
    private JLabel lblInfoFutureFooter = new JLabel("tiempo total jugado");

    public Chronometer() {
        setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        initComponents();
        setVisible(true);
    }

    public void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void showInfo(String message) {
        JOptionPane.showMessageDialog(this, message, "Información", JOptionPane.INFORMATION_MESSAGE);
    }

    public void strobe(boolean pause) {
        if (pause) {
            lblSessionStatus.setText("\u25CF Sesión no activa");
            if (lblSessionStatus.getForeground().equals(Color.decode(Utils.COLOR_GREEN))) {
                lblSessionStatus.setForeground(Color.RED);
                lblTime.setForeground(Color.RED);
            } else {
                lblSessionStatus.setForeground(Color.decode(Utils.COLOR_GREEN));
                lblTime.setForeground(Color.decode(Utils.COLOR_GREEN));
            }
        } else {
            lblSessionStatus.setText("\u25CF Sesión activa");
            lblSessionStatus.setForeground(Color.decode(Utils.COLOR_GREEN));
            lblTime.setForeground(Color.decode(Utils.COLOR_GREEN));
        }
    }

    public void setTime(String seconds) {
        lblTime.setText(seconds);
    }

    public void setTimeTotal(String seconds) {
        lblTotalTimeValue.setText(seconds);
    }

    public void setTimePaused(String seconds) {
        lblPauseTimeValue.setText(seconds);
    }

    public void setGameName(String name) {
        lblGameName.setText(name);
    }

    public void setPlayCount(String text) {
        lblPlayCountValue.setText(text);
    }

    public void setTotalPlayed(String text) {
        lblTotalPlayedGameValue.setText(text);
    }

    public void setTotalPlayedAfterSession(String text) {
        lblInfoFutureTime.setText(text);
    }

    public void setTotalFutureTime(String text) {
        lblInfoFutureTime.setText(text);
    }

    public void setAgeSession(String text) {
        lblInitDate.setText(text);
    }

    public void setAvgTimePlayed(String text) {
        lblMedTimeSessionValue.setText(text);
    }

    public void btnPauseText(String text) {
        btnPause.setText(text);
    }

    public void setPauseCount(String text) {
        lblPausesValue.setText(text);
    }

    public void setBtnPauseListener(ActionListener listener) {
        btnPause.addActionListener(listener);
    }

    public void setBtnStopListener(ActionListener listener) {
        btnStop.addActionListener(listener);
    }

    public void initComponents() {
        setResizable(false);
        setLayout(new BorderLayout(10, 10));
        setBackground(Color.decode(Utils.COLOR_BACKGROUND_PANEL_2));

        lblSeparator.setForeground(Color.GRAY);
        lblSeparator2.setForeground(Color.GRAY);
        lblSeparator3.setForeground(Color.GRAY);
        lblGameName.setFont(new Font("Arial", Font.BOLD, 20));
        lblGameName.setForeground(Color.WHITE);
        lblSessionStatus.setFont(new Font("Arial", Font.BOLD, 18));
        lblSessionStatus.setForeground(Color.decode(Utils.COLOR_GREEN));
        lblTime.setFont(new Font("Arial", Font.BOLD, 50));
        lblTime.setForeground(Color.decode(Utils.COLOR_GREEN));
        lblInfoTime.setFont(new Font("Arial", Font.BOLD, 12));
        lblInitDate.setFont(new Font("Arial", Font.BOLD, 12));
        lblTotalPlayedGame.setFont(new Font("Arial", Font.BOLD, 14));
        lblTotalPlayedGameValue.setFont(new Font("Arial", Font.BOLD, 14));

        btnStop.setBackground(Color.RED);
        btnPause.setFont(new Font("Arial", Font.BOLD, 24));
        btnStop.setFont(new Font("Arial", Font.BOLD, 24));

        JPanel pnlLeft = new JPanel();
        pnlLeft.setBackground(Color.decode(Utils.COLOR_BACKGROUND_PANEL));
        GridBagConstraints left = new GridBagConstraints();
        pnlLeft.setLayout(new GridBagLayout());

        JPanel pnlRight = new JPanel();
        pnlRight.setBackground(Color.decode(Utils.COLOR_BACKGROUND_PANEL));
        GridBagConstraints right = new GridBagConstraints();
        pnlRight.setLayout(new GridBagLayout());

        // Panel izquierdo
        left.gridheight = 1;
        left.gridwidth = 2;
        left.weightx = 1.0;
        left.weighty = 0;
        left.ipadx = 1;
        left.ipady = 1;
        left.fill = GridBagConstraints.NONE;
        left.insets = new Insets(4, 4, 4, 4);
        left.gridy = 0;
        left.gridx = 0;

        left.anchor = GridBagConstraints.CENTER;
        pnlLeft.add(lblGameName, left); // Nombre del juego
        left.gridy++;
        pnlLeft.add(lblSessionStatus, left); // Sesion activa / sesion no activa
        left.gridy++;
        pnlLeft.add(lblSeparator, left);
        left.gridy++;
        pnlLeft.add(lblTime, left); // Tiempo jugando
        left.gridy++;
        pnlLeft.add(lblInfoTime, left); // Tiempo jugado efectivo
        left.gridy++;
        pnlLeft.add(lblSeparator3, left);
        left.gridy++;
        pnlLeft.add(lblInitDate, left); // Iniciado a las........ hace.......
        left.gridy++;
        pnlLeft.add(lblSeparator2, left);
        left.gridy++;
        left.fill = GridBagConstraints.HORIZONTAL;
        pnlLeft.add(btnPause, left);
        left.gridy++;
        pnlLeft.add(btnStop, left);

        lblStats.setFont(new Font("Arial", Font.BOLD, 16));
        lblPauses.setFont(new Font("Arial", Font.BOLD, 14));
        lblPausesValue.setFont(new Font("Arial", Font.BOLD, 14));
        lblPauseTime.setFont(new Font("Arial", Font.BOLD, 14));
        lblPauseTimeValue.setFont(new Font("Arial", Font.BOLD, 14));
        lblTotalTime.setFont(new Font("Arial", Font.BOLD, 14));
        lblTotalTimeValue.setFont(new Font("Arial", Font.BOLD, 14));
        lblMedTimeSession.setFont(new Font("Arial", Font.BOLD, 14));
        lblMedTimeSessionValue.setFont(new Font("Arial", Font.BOLD, 14));
        lblPlayCount.setFont(new Font("Arial", Font.BOLD, 14));
        lblPlayCountValue.setFont(new Font("Arial", Font.BOLD, 14));
        lblInfoFuture.setHorizontalAlignment(JLabel.CENTER);
        lblInfoFutureTime.setHorizontalAlignment(JLabel.CENTER);
        lblInfoFutureFooter.setHorizontalAlignment(JLabel.CENTER);
        lblInfoFuture.setFont(new Font("Arial", Font.BOLD, 18));
        lblInfoFutureTime.setFont(new Font("Arial", Font.BOLD, 28));
        lblInfoFutureFooter.setFont(new Font("Arial", Font.BOLD, 18));
        lblInfoFutureTime.setForeground(Color.decode(Utils.COLOR_GREEN));
        
        // Panel derecho
        right.gridheight = 1;
        right.gridwidth = 1;
        right.weightx = 1.0;
        right.weighty = 0;
        right.fill = GridBagConstraints.HORIZONTAL;
        right.insets = new Insets(6, 28, 6, 12);
        right.anchor = GridBagConstraints.CENTER;
        right.gridy = 0;
        right.gridx = 0;

        JPanel pnlTitle = new JPanel(new BorderLayout()); // Estadisticas de la sesion
        pnlTitle.setBackground(Color.decode(Utils.COLOR_BACKGROUND_PANEL));
        pnlTitle.add(lblStats, BorderLayout.CENTER);
        pnlRight.add(pnlTitle, right);

        right.anchor = GridBagConstraints.EAST;
        right.gridy++;
        JPanel pnlTotalTime = new JPanel(new BorderLayout()); // Tiempo total
        pnlTotalTime.add(lblTotalTime, BorderLayout.WEST);
        pnlTotalTime.add(lblTotalTimeValue, BorderLayout.EAST);
        pnlRight.add(pnlTotalTime, right);

        right.gridy++;
        JPanel pnlPausesTime = new JPanel(new BorderLayout()); // Tiempo en pausa
        pnlPausesTime.add(lblPauseTime, BorderLayout.WEST);
        pnlPausesTime.add(lblPauseTimeValue, BorderLayout.EAST);
        pnlRight.add(pnlPausesTime, right);

        right.gridy++;
        JPanel pnlPauses = new JPanel(new BorderLayout()); // Pausas
        pnlPauses.add(lblPauses, BorderLayout.WEST);
        pnlPauses.add(lblPausesValue, BorderLayout.EAST);
        pnlRight.add(pnlPauses, right);

        right.gridy++;
        JPanel pnlMedTimeSession = new JPanel(new BorderLayout()); // Media por sesion
        pnlMedTimeSession.add(lblMedTimeSession, BorderLayout.WEST);
        pnlMedTimeSession.add(lblMedTimeSessionValue, BorderLayout.EAST);
        pnlRight.add(pnlMedTimeSession, right);

        right.gridy++;
        JPanel pnlPlayCount = new JPanel(new BorderLayout()); // Veces iniciado
        pnlPlayCount.add(lblPlayCount, BorderLayout.WEST);
        pnlPlayCount.add(lblPlayCountValue, BorderLayout.EAST);
        pnlRight.add(pnlPlayCount, right);

        right.gridy++;
        JPanel pnlTotalPlayedGame = new JPanel(new BorderLayout()); // Tiempo total jugado
        pnlTotalPlayedGame.add(lblTotalPlayedGame, BorderLayout.WEST);
        pnlTotalPlayedGame.add(lblTotalPlayedGameValue, BorderLayout.EAST);
        pnlRight.add(pnlTotalPlayedGame, right);

        right.gridy++;
        JPanel pnlInfoFuture = new JPanel(new BorderLayout()); // Con esta sesion llegaras a
        pnlInfoFuture.add(lblInfoFuture, BorderLayout.NORTH);
        pnlInfoFuture.add(lblInfoFutureTime, BorderLayout.CENTER);
        pnlInfoFuture.add(lblInfoFutureFooter, BorderLayout.SOUTH);
        pnlRight.add(pnlInfoFuture, right);

        pnlLeft.setBorder(new RoundedBorder(18, new Color(70, 70, 70), 5, 5, 5, 5));
        pnlRight.setBorder(new RoundedBorder(18, new Color(70, 70, 70), 5, 5, 5, 5));
        pnlPauses.setBorder(new RoundedBorder(18, new Color(70, 70, 70), 8, 8, 8, 8));
        pnlPausesTime.setBorder(new RoundedBorder(18, new Color(70, 70, 70), 8, 8, 8, 8));
        pnlTotalTime.setBorder(new RoundedBorder(18, new Color(70, 70, 70), 8, 8, 8, 8));
        pnlMedTimeSession.setBorder(new RoundedBorder(18, new Color(70, 70, 70), 8, 8, 8, 8));
        pnlPlayCount.setBorder(new RoundedBorder(18, new Color(70, 70, 70), 8, 8, 8, 8));
        pnlTotalPlayedGame.setBorder(new RoundedBorder(18, new Color(70, 70, 70), 8, 8, 8, 8));
        pnlInfoFuture.setBorder(new RoundedBorder(18, new Color(70, 70, 70), 8, 8, 8, 8));

        add(pnlLeft, BorderLayout.WEST);
        add(pnlRight, BorderLayout.EAST);

        FlatSVGIcon icon = new FlatSVGIcon("resources/icons/player-pause.svg", 16, 16);
        icon.setColorFilter(new FlatSVGIcon.ColorFilter(color -> Color.WHITE));
        lblPauses.setIcon(icon);

        icon = new FlatSVGIcon("resources/icons/calendar-week.svg", 16, 16);
        icon.setColorFilter(new FlatSVGIcon.ColorFilter(color -> Color.WHITE));
        lblMedTimeSession.setIcon(icon);

        icon = new FlatSVGIcon("resources/icons/trophy-prize-achievement.svg", 32, 32);
        icon.setColorFilter(new FlatSVGIcon.ColorFilter(color -> Color.WHITE));
        lblInfoFuture.setIcon(icon);

        icon = new FlatSVGIcon("resources/icons/chronometer.svg", 16, 16);
        icon.setColorFilter(new FlatSVGIcon.ColorFilter(color -> Color.WHITE));
        lblPauseTime.setIcon(icon);
        lblTotalPlayedGame.setIcon(icon);
        lblTotalTime.setIcon(icon);

        icon = new FlatSVGIcon("resources/icons/play.svg", 16, 16);
        icon.setColorFilter(new FlatSVGIcon.ColorFilter(color -> Color.WHITE));
        lblPlayCount.setIcon(icon);

        icon = new FlatSVGIcon("resources/icons/player-pause.svg", 32, 32);
        icon.setColorFilter(new FlatSVGIcon.ColorFilter(color -> Color.WHITE));
        btnPause.setIcon(icon);

        icon = new FlatSVGIcon("resources/icons/player-stop.svg", 32, 32);
        icon.setColorFilter(new FlatSVGIcon.ColorFilter(color -> Color.WHITE));
        btnStop.setIcon(icon);

        pack();
    }
}
