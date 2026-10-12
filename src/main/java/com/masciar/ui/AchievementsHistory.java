package com.masciar.ui;

import com.masciar.model.Achievement;
import com.masciar.service.ConfigService;
import com.masciar.util.DateUtils;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Timer;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseListener;

public class AchievementsHistory extends JInternalFrame implements ComponentListener {
    private Timer debounceTimer;
    private JTable table;
    private MainWindow window;
    
    public AchievementsHistory(MainWindow window) {
        this.addComponentListener(this);
        this.window = window;

        debounceTimer = new Timer(2500, e -> saveFramePosition());
		debounceTimer.setRepeats(false);

        setTitle("Logros");
        initComponents();
    }

    public void setTableListener(MouseListener listener) {
        table.addMouseListener(listener);
    }

    public JTable getTable() {
        return table;
    }

    public void showAchievementsDetails(Achievement achievement) {
        String info = "";

        info = info + "Juego: " + achievement.getGameName() + " (" + achievement.getGameId() + ")";
        info = info + "\nDescripción: " + achievement.getDescription();
        info = info + "\nFecha: " + DateUtils.formatDateFromString(achievement.getDate(), 1);
        
        window.showInfo(info);
    }

    @Override
    public void componentResized(ComponentEvent e) {
    }

    @Override
    public void componentMoved(ComponentEvent e) {
        if (debounceTimer != null)
            debounceTimer.restart();
    }

    @Override
    public void componentShown(ComponentEvent e) {
    }

    @Override
    public void componentHidden(ComponentEvent e) {
    }

    private void initComponents() {
        try {
            setLocation(Integer.parseInt(ConfigService.getProperty("AchievementsHistoryX")), Integer.parseInt(ConfigService.getProperty("AchievementsHistoryY")));
        } catch (NumberFormatException e) {
            saveFramePosition();
        }

        table = new JTable();

        JScrollPane scroll = new JScrollPane(table);
        add(scroll);

        pack();
    }

    private void saveFramePosition() {
        ConfigService.setProperty("AchievementsHistoryX", String.valueOf(this.getX()));
        ConfigService.setProperty("AchievementsHistoryY", String.valueOf(this.getY()));
    }
}
