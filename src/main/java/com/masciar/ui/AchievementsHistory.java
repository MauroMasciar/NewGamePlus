package com.masciar.ui;

import com.masciar.service.ConfigService;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Timer;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class AchievementsHistory extends JInternalFrame implements ComponentListener {
    private Timer debounceTimer;
    private JTable table;
    
    public AchievementsHistory() {
        this.addComponentListener(this);

        debounceTimer = new Timer(2500, e -> saveFramePosition());
		debounceTimer.setRepeats(false);

        setTitle("Logros");
        initComponents();
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

    public JTable getTable() {
        return table;
    }
}
