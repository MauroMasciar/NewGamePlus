package com.masciar.ui.gameinfo;

import com.masciar.service.ConfigService;
import com.masciar.util.Utils;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.Timer;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.Color;
import java.awt.GridBagConstraints;

public class GameInfo extends JInternalFrame implements ComponentListener {
    private Timer debounceUpdateWindowPositionTimer;
    private Image image;
    private Summary summary;
    private Session session;
    private JButton btnEdit = new JButton("Editar");

    public GameInfo() {
        image = new Image();
        summary = new Summary();
        session = new Session();

        try {
            setLocation(Integer.parseInt(ConfigService.getProperty("GameInfoX")), Integer.parseInt(ConfigService.getProperty("GameInfoY")));
        } catch (NumberFormatException e) {
            saveFramePosition();
        }
        setLayout(new GridBagLayout());
        setTitle("Información del juego");
        getContentPane().setBackground(Color.decode(Utils.COLOR_BACKGROUND));

        addComponentListener(this);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.ipadx = 1;
        gbc.ipady = 1;
        gbc.fill = GridBagConstraints.NONE;
        add(btnEdit, gbc);

        add(image, gbc);
        gbc.gridx++;
        add(summary, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        add(session, gbc);

        pack();

        debounceUpdateWindowPositionTimer = new Timer(2500, e -> saveFramePosition());
        debounceUpdateWindowPositionTimer.setRepeats(false);
    }

    private void saveFramePosition() {
        ConfigService.setProperty("GameInfoX", String.valueOf(this.getX()));
        ConfigService.setProperty("GameInfoY", String.valueOf(this.getY()));
    }

    public Image getImagePanel() {
        return image;
    }

    public Summary getSummaryPanel() {
        return summary;
    }

    public Session getSessionPanel() {
        return session;
    }

    public void setBtnEditListener(ActionListener listener) {
        btnEdit.addActionListener(listener);
    }

    @Override
    public void componentHidden(ComponentEvent e) {
    }

    @Override
    public void componentMoved(ComponentEvent e) {
        if (debounceUpdateWindowPositionTimer != null)
            debounceUpdateWindowPositionTimer.restart();
    }

    @Override
    public void componentResized(ComponentEvent e) {
    }

    @Override
    public void componentShown(ComponentEvent e) {
    }
}
