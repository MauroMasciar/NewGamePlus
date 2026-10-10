package com.masciar.ui;

import com.masciar.service.ConfigService;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.Timer;
import java.awt.GridLayout;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class PlayerStatistics extends JInternalFrame implements ComponentListener {
    private JLabel lblInfo = new JLabel();
    private JLabel lblInfoTwo = new JLabel();
    private JLabel lblInfoThree = new JLabel();
    private Timer debounceTimer;

    public PlayerStatistics() {
        try {
            setLocation(Integer.parseInt(ConfigService.getProperty("PlayerStatisticsX")),
                    Integer.parseInt(ConfigService.getProperty("PlayerStatisticsY")));
        } catch (NumberFormatException e) {
            saveFramePosition();
        }

        setVisible(true);
        setLayout(new GridLayout(3, 1));

        this.addComponentListener(this);

        debounceTimer = new Timer(2500, e -> saveFramePosition());
        debounceTimer.setRepeats(false);
    }

    public void setInfo(String day, String sevenDays, String twoWeeks, String month, String year, int totalGames,
            String lastAchiev) {
        String text = "Último dia: " + day + " | Semana: " + sevenDays + " | 2 semanas: " + twoWeeks + " | Mes: "
                + month + " | Año " + year;
        lblInfo.setText(text);
        add(lblInfo);

        text = "Juegos: " + totalGames;
        lblInfoTwo.setText(text);
        add(lblInfoTwo);

        text = "Último logro: " + lastAchiev;
        lblInfoThree.setText(text);
        add(lblInfoThree);

        pack();
    }

    @Override
    public void componentHidden(ComponentEvent arg0) {
    }

    @Override
    public void componentMoved(ComponentEvent arg0) {
        if (debounceTimer != null)
            debounceTimer.restart();
    }

    @Override
    public void componentResized(ComponentEvent arg0) {
    }

    @Override
    public void componentShown(ComponentEvent arg0) {
    }

    private void saveFramePosition() {
        ConfigService.setProperty("PlayerStatisticsX", String.valueOf(this.getX()));
        ConfigService.setProperty("PlayerStatisticsY", String.valueOf(this.getY()));
    }
}
