package com.masciar.ui.gameinfo;

import com.masciar.util.RoundedBorder;
import com.masciar.util.Utils;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class Session extends JPanel {
    private JPanel pnlTime = new JPanel();
    private JLabel lblTimeTitle = new JLabel("Tiempo total");
    private JLabel lblTimeHoursValue = new JLabel("0h 0m 0s");
    private JLabel lblTimeDaysValue = new JLabel("0 días 0h 0m");

    private JPanel pnlSessions = new JPanel();
    private JLabel lblSessions = new JLabel("Sesiones");
    private JLabel lblSessionsValue = new JLabel("0");
    private JLabel lblSessionsMonthValue = new JLabel("Este mes: 0");

    private JPanel pnlCompleted = new JPanel();
    private JLabel lblCompleted = new JLabel("Completado");
    private JLabel lblCompletedValue = new JLabel("0%");
    private JLabel lblCompletedAchievementValue = new JLabel("0 / 0 logros");

    private JPanel pnlLastSession = new JPanel();
    private JLabel lblLastSession = new JLabel("Última sesión");
    private JLabel lblLastSessionDate = new JLabel("01/01/1970");
    private JLabel lblLastSessionTime = new JLabel("0h 0m jugados");

    public Session() {
        setBackground(Color.decode(Utils.COLOR_BACKGROUND));
        pnlTime.setBackground(Color.decode(Utils.COLOR_BACKGROUND));
        pnlSessions.setBackground(Color.decode(Utils.COLOR_BACKGROUND));
        pnlCompleted.setBackground(Color.decode(Utils.COLOR_BACKGROUND));
        pnlLastSession.setBackground(Color.decode(Utils.COLOR_BACKGROUND));

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.ipadx = 1;
        gbc.ipady = 1;
        gbc.fill = GridBagConstraints.NONE;

        // Tiempo total
        pnlTime.setLayout(new GridBagLayout());
        pnlTime.add(lblTimeTitle, gbc);
        gbc.gridy++;
        pnlTime.add(lblTimeHoursValue, gbc);
        gbc.gridy++;
        pnlTime.add(lblTimeDaysValue, gbc);

        // Sesiones
        pnlSessions.setLayout(new GridBagLayout());
        gbc.gridy = 0;
        pnlSessions.add(lblSessions, gbc);
        gbc.gridy++;
        pnlSessions.add(lblSessionsValue, gbc);
        gbc.gridy++;
        pnlSessions.add(lblSessionsMonthValue, gbc);

        // Completado
        pnlCompleted.setLayout(new GridBagLayout());
        gbc.gridy = 0;
        pnlCompleted.add(lblCompleted, gbc);
        gbc.gridy++;
        pnlCompleted.add(lblCompletedValue, gbc);
        gbc.gridy++;
        pnlCompleted.add(lblCompletedAchievementValue, gbc);

        // Ultima sesion
        pnlLastSession.setLayout(new GridBagLayout());
        gbc.gridy = 0;
        pnlLastSession.add(lblLastSession, gbc);
        gbc.gridy++;
        pnlLastSession.add(lblLastSessionDate, gbc);
        gbc.gridy++;
        pnlLastSession.add(lblLastSessionTime, gbc);

        // Juntamos todo
        gbc.gridy = 0;
        add(pnlTime, gbc);
        gbc.gridx++;
        add(pnlSessions, gbc);
        gbc.gridx++;
        add(pnlCompleted, gbc);
        gbc.gridx++;
        add(pnlLastSession, gbc);

        configurePanels();
        configureTypography();
    }

    public void setTotalTimeHoursValue(String value) {
        lblTimeHoursValue.setText(value);
    }

    public void setTotalDaysValue(String value) {
        lblTimeDaysValue.setText(value);
    }

    public void setTotalSessionsValue(String value) {
        lblSessionsValue.setText(value);
    }

    public void setSessionsMonthValue(String value) {
        lblSessionsMonthValue.setText(value);
    }

    public void setLastSessionDate(String value) {
        lblLastSessionDate.setText(value);
    }

    public void setLastSessionTime(String value) {
        lblLastSessionTime.setText(value);
    }

    private void configurePanels() {
        pnlTime.setBorder(new RoundedBorder(18, new Color(21, 33, 47), 5, 5, 5, 5));
        pnlTime.setPreferredSize(new Dimension(175, 80));
        pnlTime.setBackground(Utils.COLOR_BACKGROUND_GAMEINFO_SESSION);

        pnlSessions.setBorder(new RoundedBorder(18, new Color(21, 33, 47), 5, 5, 5, 5));
        pnlSessions.setPreferredSize(new Dimension(175, 80));
        pnlSessions.setBackground(Utils.COLOR_BACKGROUND_GAMEINFO_SESSION);

        pnlCompleted.setBorder(new RoundedBorder(18, new Color(21, 33, 47), 5, 5, 5, 5));
        pnlCompleted.setPreferredSize(new Dimension(175, 80));
        pnlCompleted.setBackground(Utils.COLOR_BACKGROUND_GAMEINFO_SESSION);

        pnlLastSession.setBorder(new RoundedBorder(18, new Color(21, 33, 47), 5, 5, 5, 5));
        pnlLastSession.setPreferredSize(new Dimension(175, 80));
        pnlLastSession.setBackground(Utils.COLOR_BACKGROUND_GAMEINFO_SESSION);
    }

    private void configureTypography() {
        // Tiempo
        lblTimeTitle.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblTimeTitle.setForeground(Color.decode(Utils.GAME_INFO_SESSION_TEXT_VALUE));
        lblTimeHoursValue.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblTimeHoursValue.setForeground(Color.decode(Utils.GAME_INFO_SESSION_TEXT_VALUE));
        lblTimeDaysValue.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblTimeDaysValue.setForeground(Color.decode(Utils.GAME_INFO_SESSION_TEXT_VALUE));

        // Sesiones
        lblSessions.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblSessions.setForeground(Color.decode(Utils.GAME_INFO_SESSION_TEXT_VALUE));
        lblSessionsValue.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblSessionsValue.setForeground(Color.decode(Utils.GAME_INFO_SESSION_TEXT_VALUE));
        lblSessionsMonthValue.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblSessionsMonthValue.setForeground(Color.decode(Utils.GAME_INFO_SESSION_TEXT_VALUE));

        // Completado
        lblCompleted.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblCompleted.setForeground(Color.decode(Utils.GAME_INFO_SESSION_TEXT_VALUE));
        lblCompletedValue.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblCompletedValue.setForeground(Color.decode(Utils.GAME_INFO_SESSION_TEXT_VALUE));
        lblCompletedAchievementValue.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblCompletedAchievementValue.setForeground(Color.decode(Utils.GAME_INFO_SESSION_TEXT_VALUE));

        // Ultima sesion
        lblLastSession.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblLastSession.setForeground(Color.decode(Utils.GAME_INFO_SESSION_TEXT_VALUE));
        lblLastSessionDate.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblLastSessionDate.setForeground(Color.decode(Utils.GAME_INFO_SESSION_TEXT_VALUE));
        lblLastSessionTime.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblLastSessionTime.setForeground(Color.decode(Utils.GAME_INFO_SESSION_TEXT_VALUE));
    }
}
