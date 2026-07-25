package com.masciar.ui;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

public class Config extends JInternalFrame {
    private JLabel lblName = new JLabel("Nombre");
    private JTextField txtName = new JTextField();
    private JLabel lblSteamId = new JLabel("Steam ID");
    private JTextField txtSteamId = new JTextField();
    private JButton btnSave = new JButton("Guardar");
    public Config() {
        initComponents();
    }

    public void setBtnSaveListener(ActionListener listener) {
        btnSave.addActionListener(listener);
    }

    public String getTxtSteamId() {
        return txtSteamId.getText();
    }

    public void initComponents() {
        setTitle("Configuración");
        setSize(800, 500);
        setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout());

        add(lblSteamId);
        add(txtSteamId);
        add(btnSave);
        
        setVisible(true);
    }
}
