package com.masciar.controller;

import com.masciar.app.Main;
import com.masciar.model.Achievement;
import com.masciar.ui.AchievementsHistory;
import com.masciar.util.DateUtils;
import com.masciar.util.Utils;

import javax.swing.JDesktopPane;
import javax.swing.table.AbstractTableModel;
import java.util.Comparator;
import java.util.List;

public class AchievementHistoryController {
    private AchievementsHistory view;
    private AchievementTableModel achievementTableModel;

    public AchievementHistoryController(JDesktopPane desktopPane) {
        view = new AchievementsHistory();
        desktopPane.add(view);

        update();

        view.setVisible(true);
    }

    public void update() {
        achievementTableModel = new AchievementTableModel(Main.achievementsRepository.getList().stream().sorted(Comparator.comparing(Achievement::getId).reversed()).toList());
        view.getTable().setModel(achievementTableModel);
        Utils.autoSizeTable(view.getTable());
    }
}

class AchievementTableModel extends AbstractTableModel {
    private List<Achievement> list;
    private String[] columns = {
            ""
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
        return 1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getDescription() + " el " + DateUtils.formatDateFromString(list.get(rowIndex).getDate(), 4) + " a las " + DateUtils.formatDateFromString(list.get(rowIndex).getDate(), 5);
        }
        return "";
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }
}