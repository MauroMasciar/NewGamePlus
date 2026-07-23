// TODO: Crear controlador y service para esto
package com.masciar.ui;

import com.masciar.model.History;
import com.masciar.util.Utils;
import com.masciar.app.Main;

import java.util.Comparator;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class SessionsHistoryInternalFrame extends JInternalFrame {
    private static HistoryTableModel historyTableModel;
    private static JTable table;
    public SessionsHistoryInternalFrame() {
        setTitle("Historial de juego");
        setSize(450, 500);
        initComponents();
    }

    private void initComponents() {
        table = new JTable();
        updateTableModel();
        
        JScrollPane scroll = new JScrollPane(table);
        add(scroll);
        Utils.autoSizeTable(table);

        pack();
        setVisible(true);
    }

    public static void updateTableModel() {
        List<History> history = Main.historyRepository.history_list.stream().sorted(Comparator.comparing(History::getDateTimeStart).reversed()).toList();
        historyTableModel = new HistoryTableModel(history);

        table.setModel(historyTableModel);
    }
}

class HistoryTableModel extends AbstractTableModel {
    private List<History> list;
    private String[] columns = {
        "Juego", "Horas", "Ultima sesión"
    };

    public HistoryTableModel(List<History> list) {
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0: return list.get(rowIndex).getGameName();
            case 1: return Utils.getTotalHoursFromSeconds(list.get(rowIndex).getSeconds(), true);
            case 2: return Utils.formatDateFromString(list.get(rowIndex).getDateTimeStart());
        }
        return "";
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }
}