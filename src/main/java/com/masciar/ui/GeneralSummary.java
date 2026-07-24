package com.masciar.ui;

import javax.swing.BorderFactory;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class GeneralSummary extends JInternalFrame {
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
    
    public GeneralSummary() {
        initComponents();
    }

    public void setLblTotalTimeHoursValue(String text) {
        lblTotalTimeHoursValue.setText(text);
    }

    public void setlblTotalTimeDaysValue(String text) {
        lblTotalTimeDaysValue.setText(text);
    }

    public void lblTotalGamesStartedValue(String text) {
        lblTotalGamesStartedValue.setText(text);
    }

    public void lblCompletedValue(String text) {
        lblCompletedValue.setText(text);
    }

    public void lblSessionsValue(String text) {
        lblSessionsValue.setText(text);
    }
    
    public void initComponents() {
        setName("General Summary");
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
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.ipadx = 1;
        gbc.ipady = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(panelTitle, gbc);
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

        Border linea = BorderFactory.createLineBorder(Color.DARK_GRAY, 1);
        Border margen = BorderFactory.createEmptyBorder(10, 10, 10, 10);

        panelTime.setBorder(BorderFactory.createCompoundBorder(linea, margen));
        panelGameStarted.setBorder(BorderFactory.createCompoundBorder(linea, margen));
        panelCompleted.setBorder(BorderFactory.createCompoundBorder(linea, margen));
        panelSessions.setBorder(BorderFactory.createCompoundBorder(linea, margen));

        pack();
        setVisible(true);
    }
}
