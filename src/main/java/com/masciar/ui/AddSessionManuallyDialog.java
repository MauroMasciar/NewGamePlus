package com.masciar.ui;

import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.SpinnerNumberModel;
import javax.swing.WindowConstants;
import com.raven.datechooser.DateChooser;
import raven.datetime.component.time.TimePicker;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

public class AddSessionManuallyDialog extends JDialog {
    private final JLabel lblGame = new JLabel(" Juego:");
    private final JLabel lblTime = new JLabel(" Minutos:");
    private final JLabel lblDate = new JLabel(" Fecha:");
    private final JLabel lblHour = new JLabel(" Hora:");
    private final JFormattedTextField txtTime = new JFormattedTextField();
    private final JTextField txtDate = new JTextField();
    private final DateChooser dcDate = new DateChooser();
    private TimePicker timePicker = new TimePicker();
    private final JComboBox<String> cbGame = new JComboBox<>();
    private final JSpinner spinTime = new JSpinner();
    private final SpinnerNumberModel spnModelTime = new SpinnerNumberModel();
    private final JButton btnAdd = new JButton();

    public AddSessionManuallyDialog(MainWindow window, boolean modal) {
        super(window, true);
        setTitle("Añadir nueva sesión");
        setLayout(new GridBagLayout());
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(100, 80, 400, 170);

        initComponents();
    }

    public void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void showInfo(String message) {
        JOptionPane.showMessageDialog(this, message, "Información", JOptionPane.INFORMATION_MESSAGE);
    }

    public void cbGameAddItem(String value) {
        cbGame.addItem(value);
    }

    public void setBtnAddListener(ActionListener listener) {
        btnAdd.addActionListener(listener);
    }

    public String getGameSelectedString() {
        return cbGame.getSelectedItem().toString();
    }

    public String getTimeString() {
        return spinTime.getValue().toString();
    }

    public String getDateString() {
        return txtDate.getText();
    }

    public String getHourString() {
        return txtTime.getText();
    }

    public void initComponents() {
        setLayout(new GridBagLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        btnAdd.setText("Añadir");
        timePicker.set24HourView(true);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.ipadx = 1;
        gbc.ipady = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(lblGame, gbc);
        gbc.gridx++;
        panel.add(cbGame, gbc);
        gbc.gridx = 0;
        gbc.gridy ++;
        panel.add(lblTime, gbc);
        gbc.gridx++;
        panel.add(spinTime, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(lblDate, gbc);
        gbc.gridx++;
        panel.add(txtDate, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(lblHour, gbc);
        gbc.gridx++;
        panel.add(txtTime, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        panel.add(btnAdd, gbc);
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(panel, gbc);

        spnModelTime.setMinimum(0);
        spinTime.setModel(spnModelTime);
        spinTime.setToolTipText("El tiempo es en minutos");
        
        dcDate.hidePopup();
        dcDate.setDateFormat("yyyy-MM-dd");
        dcDate.setTextRefernce(txtDate);
        timePicker.setEditor(txtTime);
    }
}
