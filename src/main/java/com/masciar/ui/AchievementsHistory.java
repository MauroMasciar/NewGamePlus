package com.masciar.ui;

import com.masciar.service.ConfigService;
import com.masciar.util.Utils;
import com.masciar.app.Main;
import com.masciar.model.Achievement;
import com.masciar.model.History;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.AbstractTableModel;
import java.util.Comparator;
import java.util.List;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class AchievementsHistory extends JInternalFrame implements ComponentListener {
    private Timer debounceTimer;
    private static JTable table;
    private static AchievementTableModel achievementTableModel;
    public AchievementsHistory() {
        this.addComponentListener(this);

        debounceTimer = new Timer(2500, e -> saveFramePosition());
		debounceTimer.setRepeats(false);

        setTitle("Logros");
        setSize(450, 500);
        initComponents();
    }

    public static void updateTableModel() {
        achievementTableModel = new AchievementTableModel(Main.achievementsRepository.getList());

        table.setModel(achievementTableModel);
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
        updateTableModel();

        JScrollPane scroll = new JScrollPane(table);
        add(scroll);
        Utils.autoSizeTable(table);

        pack();
    }

    private void saveFramePosition() {
        ConfigService.setProperty("AchievementsHistoryX", String.valueOf(this.getX()));
        ConfigService.setProperty("AchievementsHistoryY", String.valueOf(this.getY()));
    }
}

class AchievementTableModel extends AbstractTableModel {
    private List<Achievement> list;
    private String[] columns = {
        "Juego", "Logro"
    };

    public AchievementTableModel(List<Achievement> list) {
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getGameName();
            case 1:
                return list.get(rowIndex).getDescription();
        }
        return "";
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }
}
