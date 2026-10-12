package com.masciar.controller;

import com.masciar.app.Main;
import com.masciar.ui.MainWindow;
import com.masciar.model.Achievement;
import com.masciar.ui.AchievementsHistory;
import com.masciar.util.DateUtils;
import com.masciar.util.Utils;

import javax.swing.table.AbstractTableModel;
import java.awt.event.MouseAdapter;
import java.util.Comparator;
import java.util.List;

public class AchievementHistoryController {
    private AchievementsHistory view;
    private AchievementTableModel achievementTableModel;

    public AchievementHistoryController(MainWindow window) {
        view = new AchievementsHistory(window);
        window.add(view);

        view.setTableListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                if(e.getClickCount() == 2) showDetails();
            }
        });

        update();

        view.setVisible(true);
    }

    public void update() {
        achievementTableModel = new AchievementTableModel(Main.achievementsRepository.getList().stream().sorted(Comparator.comparing(Achievement::getDate).reversed()).toList());
        view.getTable().setModel(achievementTableModel);
        Utils.autoSizeTable(view.getTable());
    }

    private void showDetails() {
        view.showAchievementsDetails(achievementTableModel.getAchievementSelected(view.getTable().getSelectedRow()));
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

    public Achievement getAchievementSelected(int rowIndex) {
        return list.get(rowIndex);
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
                return list.get(rowIndex).getDescription() + " (" + DateUtils.formatDateFromString(list.get(rowIndex).getDate(), 4) + " " + DateUtils.formatDateFromString(list.get(rowIndex).getDate(), 5) + ")";
        }
        return "";
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }
}