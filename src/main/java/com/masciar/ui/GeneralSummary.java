package com.masciar.ui;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.masciar.service.ConfigService;
import com.masciar.util.RoundedBorder;
import com.masciar.util.Utils;

public class GeneralSummary extends JInternalFrame implements ComponentListener {
    private JPanel panelTitle = new JPanel();
    private JLabel lblTitle = new JLabel("Resumen general");
    private JPanel panelTime = new JPanel();
    private JLabel lblTotalTime = new JLabel("Tiempo total");
    private JLabel lblTotalTimeHoursValue = new JLabel("No se pudieron cargar los datos");
    private JLabel lblTotalTimeDaysValue = new JLabel("No se pudieron cargar los datos");
    private JPanel panelGameStarted = new JPanel();
    private JLabel lblTotalGamesStarted = new JLabel("Juegos iniciados");
    private JLabel lblTotalGamesStartedValue = new JLabel("No se pudieron cargar los datos");
    private JPanel panelCompleted = new JPanel();
    private JLabel lblCompleted = new JLabel("Completados");
    private JLabel lblCompletedValue = new JLabel("No se pudieron cargar los datos");
    private JPanel panelSessions = new JPanel();
    private JLabel lblSessions = new JLabel("Sesiones");
    private JLabel lblSessionsValue = new JLabel("No se pudieron cargar los datos");
    private Timer debounceUpdateWindowPositionTimer;

    public GeneralSummary() {
        createLayout();
        configurePanels();
        configureTypography();
        configureIcons();
        setResizable(true);

        this.getContentPane().setBackground(Color.decode(Utils.COLOR_BACKGROUND));

        pack();
        
        setVisible(true);

        this.addComponentListener(this);

        debounceUpdateWindowPositionTimer = new Timer(2500, e -> saveFramePosition());
		debounceUpdateWindowPositionTimer.setRepeats(false);
    }

    private void configurePanels() {
        panelTitle.setBackground(new Color(18, 18, 20));
        panelTime.setBackground(new Color(21, 33, 47, 85));
        panelGameStarted.setBackground(new Color(24, 35, 37, 85));
        panelCompleted.setBackground(new Color(71, 42, 85, 85));
        panelSessions.setBackground(new Color(82, 25, 14, 85));

        panelTime.setBorder(new RoundedBorder(18, new Color(21, 33, 47), 5, 5, 5, 5));
        panelGameStarted.setBorder(new RoundedBorder(18, new Color(24, 35, 37), 5, 5, 5, 5));
        panelCompleted.setBorder(new RoundedBorder(18, new Color(71, 42, 85, 75), 5, 5, 5, 5));
        panelSessions.setBorder(new RoundedBorder(18, new Color(82, 25, 14, 75), 5, 5, 5, 5));

        panelTime.setPreferredSize(new Dimension(175, 75));
        panelGameStarted.setPreferredSize(new Dimension(175, 75));
        panelCompleted.setPreferredSize(new Dimension(175, 75));
        panelSessions.setPreferredSize(new Dimension(175, 75));
    }

    private void configureTypography() {
        /* Tiempo total */
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 20));

        lblTotalTime.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        lblTotalTime.setForeground(new Color(130, 145, 160));

        lblTotalTimeHoursValue.setFont(new Font("Segoe UI", Font.BOLD, 28));
        lblTotalTimeHoursValue.setForeground(new Color(0, 150, 255));

        lblTotalTimeDaysValue.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblTotalTimeDaysValue.setForeground(new Color(130, 145, 160));

        /* Completados */
        lblCompleted.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        lblCompleted.setForeground(new Color(130, 145, 160));

        lblCompletedValue.setFont(new Font("Segoe UI", Font.BOLD, 28));
        lblCompletedValue.setForeground(new Color(220, 230, 255)); //% 190, 110, 255

        /* Juegos iniciados */
        lblTotalGamesStarted.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        lblTotalGamesStarted.setForeground(new Color(130, 145, 160));

        lblTotalGamesStartedValue.setFont(new Font("Segoe UI", Font.BOLD, 28));
        lblTotalGamesStartedValue.setForeground(new Color(240, 255, 240));
        
        /* Sesiones */
        lblSessions.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        lblSessions.setForeground(new Color(130, 145, 160));

        lblSessionsValue.setFont(new Font("Segoe UI", Font.BOLD, 28));
        lblSessionsValue.setForeground(new Color(255, 220, 160));
    }

    private void configureIcons() {
        FlatSVGIcon icon = new FlatSVGIcon("resources/icons/general-summary.svg", 16, 16);
        icon.setColorFilter(new FlatSVGIcon.ColorFilter(color -> Color.WHITE));
        lblTitle.setIcon(icon);
    }

    private void createLayout() {        
        try {
            setLocation(Integer.parseInt(ConfigService.getProperty("GeneralSummaryX")), Integer.parseInt(ConfigService.getProperty("GeneralSummaryY")));
        } catch (NumberFormatException e) {
            saveFramePosition();
        }

        setLayout(new GridBagLayout());
        panelTitle.setLayout(new GridBagLayout());
        panelTime.setLayout(new GridBagLayout());
        panelGameStarted.setLayout(new GridBagLayout());
        panelCompleted.setLayout(new GridBagLayout());
        panelSessions.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        GridBagConstraints gbcPanels = new GridBagConstraints();

        gbcPanels.gridx = 0;
        gbcPanels.gridy = 0;
        gbcPanels.gridwidth = 1;
        gbcPanels.gridheight = 1;
        gbcPanels.weightx = 1.0;
        gbcPanels.weighty = 1.0;
        gbcPanels.ipadx = 1;
        gbcPanels.ipady = 1;
        //gbcPanels.insets = new Insets(5, 5, 5, 5);
        gbcPanels.fill = GridBagConstraints.HORIZONTAL;

        panelTitle.add(lblTitle, gbcPanels);

        gbcPanels.gridx = 0;
        gbcPanels.gridy = 0;
        panelTime.add(lblTotalTime, gbcPanels);
        gbcPanels.gridy++;
        panelTime.add(lblTotalTimeHoursValue, gbcPanels);
        gbcPanels.gridy++;
        panelTime.add(lblTotalTimeDaysValue, gbcPanels);

        gbcPanels.gridx = 0;
        gbcPanels.gridy = 0;
        panelGameStarted.add(lblTotalGamesStarted, gbcPanels);
        gbcPanels.gridy++;
        panelGameStarted.add(lblTotalGamesStartedValue, gbcPanels);

        gbcPanels.gridx = 0;
        gbcPanels.gridy = 0;
        panelCompleted.add(lblCompleted, gbcPanels);
        gbcPanels.gridy++;
        panelCompleted.add(lblCompletedValue, gbcPanels);

        gbcPanels.gridx = 0;
        gbcPanels.gridy = 0;
        panelSessions.add(lblSessions, gbcPanels);
        gbcPanels.gridy++;
        panelSessions.add(lblSessionsValue, gbcPanels);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.ipadx = 1;
        gbc.ipady = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = new Insets(0, 0, 10, 0); // arriba izq abajo derecha
        add(panelTitle, gbc);
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridwidth = 1;
        gbc.gridy++;
        add(panelTime, gbc);
        gbc.gridx++;
        add(panelGameStarted, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        add(panelCompleted, gbc);
        gbc.gridx++;
        add(panelSessions, gbc);        
    }

    private void saveFramePosition() {
        ConfigService.setProperty("GeneralSummaryX", String.valueOf(this.getX()));
        ConfigService.setProperty("GeneralSummaryY", String.valueOf(this.getY()));
    }

    public void setLblTotalTimeHoursValue(String text) {
        lblTotalTimeHoursValue.setText(text);
    }

    public void setlblTotalTimeDaysValue(String text) {
        lblTotalTimeDaysValue.setText(text);
    }

    public void setLblTotalGamesStartedValue(String text) {
        lblTotalGamesStartedValue.setText(text);
    }

    public void setLblCompletedValue(String text) {
        lblCompletedValue.setText(text);
    }

    public void setLblSessionsValue(String text) {
        lblSessionsValue.setText(text);
    }

    @Override
    public void componentHidden(ComponentEvent e) {
    }

    @Override
    public void componentMoved(ComponentEvent e) {
        if(debounceUpdateWindowPositionTimer != null) debounceUpdateWindowPositionTimer.restart();
    }

    @Override
    public void componentResized(ComponentEvent e) {
    }

    @Override
    public void componentShown(ComponentEvent e) {
    }
}
