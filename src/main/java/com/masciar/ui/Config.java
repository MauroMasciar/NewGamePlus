package com.masciar.ui;

import com.masciar.service.ConfigService;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Timer;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class Config extends JInternalFrame implements ComponentListener {
    private JLabel lblName = new JLabel("Nombre");
    private JTextField txtName = new JTextField();
    private JLabel lblSteamId = new JLabel("Steam ID");
    private JTextField txtSteamId = new JTextField();
    private JButton btnSave = new JButton("Guardar");
    private Timer debounceTimer;

    public Config() {
        initComponents();

        this.addComponentListener(this);

        debounceTimer = new Timer(2500, e -> saveFramePosition());
		debounceTimer.setRepeats(false);
    }

    private void initComponents() {
        setLocation(Integer.parseInt(ConfigService.getProperty("ConfigX")), Integer.parseInt(ConfigService.getProperty("ConfigY")));
        setTitle("Configuración");
        setSize(800, 500);
        setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout());

        add(lblSteamId);
        add(txtSteamId);
        add(btnSave);

        setVisible(true);
    }

    private void saveFramePosition() {
        ConfigService.setProperty("ConfigX", String.valueOf(this.getX()));
        ConfigService.setProperty("ConfigY", String.valueOf(this.getY()));
    }

    public void setBtnSaveListener(ActionListener listener) {
        btnSave.addActionListener(listener);
    }

    public String getTxtSteamId() {
        return txtSteamId.getText();
    }

    public void setTxtSteamId(String steamId) {
        txtSteamId.setText(steamId);
    }

    @Override
    public void componentHidden(ComponentEvent e) {
    }

    @Override
    public void componentMoved(ComponentEvent e) {
        if(debounceTimer != null) debounceTimer.restart();
    }

    @Override
    public void componentResized(ComponentEvent e) {
    }

    @Override
    public void componentShown(ComponentEvent e) {
    }
}
