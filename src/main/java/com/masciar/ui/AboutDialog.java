package com.masciar.ui;

import com.masciar.app.Main;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class AboutDialog extends JDialog {
    private final JPanel pnlInfo = new JPanel();
    private final JLabel lblFirstLine = new JLabel();
    private final JLabel lblSecondLine = new JLabel();

    public AboutDialog(MainWindow window, boolean modal) {
        super(window, true);
        setBounds(90, 70, 420, 100);
        setTitle("Acerca de");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        lblFirstLine.setText("Software desarrollado por Mauro Masciadro - MASCIAR - Version " + Main.VERSION_APP);
        lblSecondLine.setText("https://dywtpn.fun/");

        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.ipadx = 40;
        gbc.ipady = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        pnlInfo.add(lblFirstLine, gbc);
        gbc.gridy++;
        pnlInfo.add(lblSecondLine, gbc);

        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.ipadx = 40;
        gbc.ipady = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(pnlInfo, gbc);

        setVisible(true);
    }
}
