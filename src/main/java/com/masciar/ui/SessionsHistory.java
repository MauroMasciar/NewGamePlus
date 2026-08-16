// TODO: Crear controlador y service para esto
package com.masciar.ui;

import com.masciar.model.History;
import com.masciar.service.ConfigService;
import com.masciar.util.DateUtils;
import com.masciar.util.TimeUtils;
import com.masciar.util.Utils;
import com.masciar.app.Main;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.Comparator;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.AbstractTableModel;

public class SessionsHistory extends JInternalFrame implements ComponentListener {
    private static HistoryTableModel historyTableModel;
    private static JTable table;
    private Timer debounceTimer;

    public SessionsHistory() {
        this.addComponentListener(this);

        debounceTimer = new Timer(2500, e -> saveFramePosition());
		debounceTimer.setRepeats(false);

        setTitle("Historial de juego");
        setSize(450, 500);
        initComponents();
    }

    private void initComponents() {
        try {
            setLocation(Integer.parseInt(ConfigService.getProperty("SessionsHistoryX")), Integer.parseInt(ConfigService.getProperty("SessionsHistoryY")));
        } catch (NumberFormatException e) {
            saveFramePosition();
        }
        
        table = new JTable();
        updateTableModel();

        JScrollPane scroll = new JScrollPane(table);
        add(scroll);
        Utils.autoSizeTable(table);

        pack();
        setVisible(true);
    }

    private void saveFramePosition() {
        ConfigService.setProperty("SessionsHistoryX", String.valueOf(this.getX()));
        ConfigService.setProperty("SessionsHistoryY", String.valueOf(this.getY()));
    }

    public static void updateTableModel() {
        List<History> history = Main.historyRepository.history_list.stream()
                .sorted(Comparator.comparing(History::getDateTimeStart).reversed()).toList();
        historyTableModel = new HistoryTableModel(history);

        table.setModel(historyTableModel);
    }

    @Override
    public void componentHidden(ComponentEvent e) {
    }

    @Override
    public void componentMoved(ComponentEvent e) {
        if (debounceTimer != null)
            debounceTimer.restart();
    }

    @Override
    public void componentResized(ComponentEvent e) {
    }

    @Override
    public void componentShown(ComponentEvent e) {
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
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getGameName();
            case 1:
                return TimeUtils.getTotalHoursFromSeconds(list.get(rowIndex).getSeconds(), true);
            case 2:
                return DateUtils.formatDateFromString(list.get(rowIndex).getDateTimeStart(), 1);
        }
        return "";
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }
}