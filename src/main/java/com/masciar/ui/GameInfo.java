package com.masciar.ui;

import com.masciar.service.ConfigService;
import com.masciar.util.Utils;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class GameInfo extends JInternalFrame implements ComponentListener {
    // Ficha del juego
    private JPanel panelGameInfo = new JPanel();
    private JLabel lblName = new JLabel("Nombre del juego");
    private JLabel lblLibrary = new JLabel("Libreria");
    private JLabel lblCategory = new JLabel("Categoria");
    private JLabel lblPlatform = new JLabel("Plataforma");

    // Ficha del jugador sobre el juego seleccionado
    private JPanel panelPlayerInfo = new JPanel();
    private JPanel panelTotalTime = new JPanel();
    private JLabel lblTotalTime = new JLabel("Tiempo total");
    private JLabel lblTotalTimeHoursValue = new JLabel("0h 0m 0s");
    private JLabel lblTotalDaysValue = new JLabel("0 días 0h 0m");
    private JPanel panelTotalSessions = new JPanel();
    private JLabel lblTotalSessions = new JLabel("Sesiones");
    private JLabel lblTotalSessionsValue = new JLabel("0");
    private JPanel panelLastSession = new JPanel();
    private JLabel lblLastSession = new JLabel("Ultima sesion");
    private JLabel lblLastSessionValue = new JLabel("01/01/1900");
    private JLabel lblLastSessionTimeValue = new JLabel("0h 0m");
    private Timer debounceUpdateWindowPositionTimer;

    public GameInfo() {
        this.getContentPane().setBackground(Color.decode(Utils.COLOR_BACKGROUND));
        initComponents();

        this.addComponentListener(this);

        debounceUpdateWindowPositionTimer = new Timer(2500, e -> saveFramePosition());
        debounceUpdateWindowPositionTimer.setRepeats(false);

        setVisible(true);
    }

    private void initComponents() {
        setLocation(Integer.parseInt(ConfigService.getProperty("GameInfoX")), Integer.parseInt(ConfigService.getProperty("GameInfoY")));
        setLayout(new GridBagLayout());
        panelGameInfo.setLayout(new GridBagLayout());
        panelPlayerInfo.setLayout(new GridBagLayout());

        panelTotalTime.setLayout(new GridBagLayout());
        panelTotalSessions.setLayout(new GridBagLayout());
        panelLastSession.setLayout(new GridBagLayout());

        GridBagConstraints gbcPanelGameInfo = new GridBagConstraints();
        gbcPanelGameInfo.gridx = 0;
        gbcPanelGameInfo.gridy = 0;
        gbcPanelGameInfo.gridwidth = 1;
        gbcPanelGameInfo.gridheight = 1;
        gbcPanelGameInfo.weightx = 1.0;
        gbcPanelGameInfo.weighty = 1.0;
        gbcPanelGameInfo.ipadx = 1;
        gbcPanelGameInfo.ipady = 1;
        gbcPanelGameInfo.fill = GridBagConstraints.HORIZONTAL;
        panelGameInfo.add(lblName, gbcPanelGameInfo);
        gbcPanelGameInfo.gridy++;
        panelGameInfo.add(lblLibrary, gbcPanelGameInfo);
        gbcPanelGameInfo.gridx++;
        panelGameInfo.add(lblCategory, gbcPanelGameInfo);
        gbcPanelGameInfo.gridx++;
        panelGameInfo.add(lblPlatform, gbcPanelGameInfo);

        GridBagConstraints gbcTotalTime = new GridBagConstraints();
        gbcTotalTime.gridx = 0;
        gbcTotalTime.gridy = 0;
        gbcTotalTime.gridwidth = 1;
        gbcTotalTime.gridheight = 1;
        gbcTotalTime.weightx = 1.0;
        gbcTotalTime.weighty = 1.0;
        gbcTotalTime.ipadx = 1;
        gbcTotalTime.ipady = 1;
        gbcTotalTime.fill = GridBagConstraints.HORIZONTAL;

        panelTotalTime.add(lblTotalTime, gbcTotalTime);
        gbcTotalTime.gridx++;
        panelTotalTime.add(lblTotalTimeHoursValue, gbcTotalTime);
        gbcTotalTime.gridx++;
        panelTotalTime.add(lblTotalDaysValue, gbcTotalTime);
        gbcTotalTime.gridx = 0;
        gbcTotalTime.gridy++;

        GridBagConstraints gbcTotalSessions = new GridBagConstraints();
        gbcTotalSessions.gridx = 0;
        gbcTotalSessions.gridy = 0;
        gbcTotalSessions.gridwidth = 1;
        gbcTotalSessions.gridheight = 1;
        gbcTotalSessions.weightx = 1.0;
        gbcTotalSessions.weighty = 1.0;
        gbcTotalSessions.ipadx = 1;
        gbcTotalSessions.ipady = 1;
        gbcTotalSessions.fill = GridBagConstraints.HORIZONTAL;

        panelTotalSessions.add(lblTotalSessions, gbcTotalSessions);
        gbcTotalSessions.gridx++;
        panelTotalSessions.add(lblTotalSessionsValue, gbcTotalSessions);
        gbcTotalSessions.gridx = 0;
        gbcTotalSessions.gridy++;

        GridBagConstraints gbcLastSession = new GridBagConstraints();
        gbcLastSession.gridx = 0;
        gbcLastSession.gridy = 0;
        gbcLastSession.gridwidth = 1;
        gbcLastSession.gridheight = 1;
        gbcLastSession.weightx = 1.0;
        gbcLastSession.weighty = 1.0;
        gbcLastSession.ipadx = 1;
        gbcLastSession.ipady = 1;
        gbcLastSession.fill = GridBagConstraints.HORIZONTAL;

        panelLastSession.add(lblLastSession, gbcLastSession);
        gbcLastSession.gridx++;
        panelLastSession.add(lblLastSessionValue, gbcLastSession);
        gbcLastSession.gridx++;
        panelLastSession.add(lblLastSessionTimeValue, gbcLastSession);
        gbcLastSession.gridx = 0;
        gbcLastSession.gridy++;

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.ipadx = 1;
        gbc.ipady = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelPlayerInfo.add(panelTotalTime, gbc);
        gbc.gridx++;
        panelPlayerInfo.add(panelTotalSessions, gbc);
        gbc.gridx++;
        panelPlayerInfo.add(panelLastSession, gbc);

        GridBagConstraints gbcPanels = new GridBagConstraints();
        gbcPanels.gridx = 0;
        gbcPanels.gridy = 0;
        gbcPanels.gridwidth = 1;
        gbcPanels.gridheight = 1;
        gbcPanels.weightx = 1.0;
        gbcPanels.weighty = 1.0;
        gbcPanels.ipadx = 1;
        gbcPanels.ipady = 1;
        gbcPanels.fill = GridBagConstraints.HORIZONTAL;
        add(panelGameInfo, gbcPanels);
        gbcPanels.gridy++;
        add(panelPlayerInfo, gbcPanels);

        panelGameInfo.setBackground(Color.decode(Utils.COLOR_BACKGROUND));
        panelPlayerInfo.setBackground(Color.decode(Utils.COLOR_BACKGROUND));
        panelTotalTime.setBackground(Color.decode(Utils.COLOR_BACKGROUND));
        panelTotalSessions.setBackground(Color.decode(Utils.COLOR_BACKGROUND));
        panelLastSession.setBackground(Color.decode(Utils.COLOR_BACKGROUND));

        pack();
    }

    private void saveFramePosition() {
        ConfigService.setProperty("GameInfoX", String.valueOf(this.getX()));
        ConfigService.setProperty("GameInfoY", String.valueOf(this.getY()));
    }

    @Override
    public void componentHidden(ComponentEvent e) {
    }

    @Override
    public void componentMoved(ComponentEvent e) {
        if (debounceUpdateWindowPositionTimer != null)
            debounceUpdateWindowPositionTimer.restart();
    }

    @Override
    public void componentResized(ComponentEvent e) {
    }

    @Override
    public void componentShown(ComponentEvent e) {
    }

    public void setGameName(String name) {
        lblName.setText(name);
    }

    public void setLibrary(String library) {
        lblLibrary.setText(library);
    }

    public void setCategory(String category) {
        lblCategory.setText(category);
    }

    public void setPlatform(String platform) {
        lblPlatform.setText(platform);
    }

    public void setTotalTimeHoursValue(String totalTimeHoursValue) {
        lblTotalTimeHoursValue.setText(totalTimeHoursValue);
    }

    public void setTotalDaysValue(String totalDaysValue) {
        lblTotalDaysValue.setText(totalDaysValue);
    }

    public void setTotalSessionsValue(String totalSessionsValue) {
        lblTotalSessionsValue.setText(totalSessionsValue);
    }

    public void setLastSessionValue(String lastSessionValue) {
        lblLastSessionValue.setText(lastSessionValue);
    }

    public void setLastSessionTimeValue(String lastSessionTimeValue) {
        lblLastSessionTimeValue.setText(lastSessionTimeValue);
    }
}
