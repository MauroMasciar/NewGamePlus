package com.masciar.ui.gameinfo;

import com.masciar.util.RoundedBorder;
import com.masciar.util.Utils;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class Summary extends JPanel {
    private JLabel lblGameName = new JLabel("NOMBRE DEL JUEGO");
    private JLabel lblCategory = new JLabel("Categoría");
    private JLabel lblCategoryValue = new JLabel("CATEGORÍA");
    private JLabel lblPlatform = new JLabel("Plataforma");
    private JLabel lblPlatformValue = new JLabel("PLATAFORMA");
    private JLabel lblLibrary = new JLabel("Biblioteca");
    private JLabel lblLibraryValue = new JLabel("BIBLIOTECA");
    private JLabel lblState = new JLabel("Estado");
    private JLabel lblStateValue = new JLabel("NO COMPLETADO");
    private JPanel pnlPlatform = new JPanel();
    private JPanel pnlLibrary = new JPanel();
    private JPanel pnlCategory = new JPanel();
    private JPanel pnlState = new JPanel();

    public Summary() {
        setBackground(Color.decode(Utils.COLOR_BACKGROUND));
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.gridheight = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.ipadx = 1;
        gbc.ipady = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(lblGameName, gbc);
        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;

        createPlatformPanel();
        createLibraryPanel();
        createCategoryPanel();
        createStatePanel();

        add(pnlPlatform, gbc);
        gbc.gridx++;
        add(pnlLibrary, gbc);
        gbc.gridx++;
        add(pnlCategory, gbc);
        gbc.gridx++;
        add(pnlState, gbc);

        configureTypography();
    }

    private void createPlatformPanel() {
        pnlPlatform.setBorder(new RoundedBorder(18, new Color(21, 33, 47), 5, 5, 5, 5));
        pnlPlatform.setBackground(Color.decode(Utils.COLOR_BACKGROUND));
        pnlPlatform.setLayout(new GridBagLayout());
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

        pnlPlatform.add(lblPlatform, gbc);
        gbc.gridy++;
        pnlPlatform.add(lblPlatformValue, gbc);
    }

    private void createLibraryPanel() {
        pnlLibrary.setBorder(new RoundedBorder(18, new Color(21, 33, 47), 5, 5, 5, 5));
        pnlLibrary.setBackground(Color.decode(Utils.COLOR_BACKGROUND));
        pnlLibrary.setLayout(new GridBagLayout());
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
        pnlLibrary.add(lblLibrary, gbc);
        gbc.gridy++;
        pnlLibrary.add(lblLibraryValue, gbc);
    }

    private void createCategoryPanel() {
        pnlCategory.setBorder(new RoundedBorder(18, new Color(21, 33, 47), 5, 5, 5, 5));
        pnlCategory.setBackground(Color.decode(Utils.COLOR_BACKGROUND));
        pnlCategory.setLayout(new GridBagLayout());
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
        pnlCategory.add(lblCategory, gbc);
        gbc.gridy++;
        pnlCategory.add(lblCategoryValue, gbc);
    }

    private void createStatePanel() {
        pnlState.setBorder(new RoundedBorder(18, new Color(21, 33, 47), 5, 5, 5, 5));
        pnlState.setBackground(Color.decode(Utils.COLOR_BACKGROUND));
        pnlState.setLayout(new GridBagLayout());
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
        pnlState.add(lblState, gbc);
        gbc.gridy++;
        pnlState.add(lblStateValue, gbc);
    }

    private void configureTypography() {
        lblGameName.setFont(new Font("Segoe UI", Font.BOLD, 32));
        lblGameName.setForeground(Color.decode(Utils.GAME_INFO_SESSION_TEXT_VALUE));

        lblCategory.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        lblCategory.setForeground(Color.decode(Utils.GAME_INFO_SESSION_TEXT_VALUE));
        lblCategoryValue.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblCategoryValue.setForeground(Color.decode(Utils.GAME_INFO_SESSION_TEXT_VALUE));

        lblPlatform.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        lblPlatform.setForeground(Color.decode(Utils.GAME_INFO_SESSION_TEXT_VALUE));
        lblPlatformValue.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblPlatformValue.setForeground(Color.decode(Utils.GAME_INFO_SESSION_TEXT_VALUE));

        lblLibrary.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        lblLibrary.setForeground(Color.decode(Utils.GAME_INFO_SESSION_TEXT_VALUE));
        lblLibraryValue.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblLibraryValue.setForeground(Color.decode(Utils.GAME_INFO_SESSION_TEXT_VALUE));

        lblState.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        lblState.setForeground(Color.decode(Utils.GAME_INFO_SESSION_TEXT_VALUE));
        lblStateValue.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblStateValue.setForeground(Color.decode(Utils.GAME_INFO_SESSION_TEXT_VALUE));
    }

    public void setGameName(String name) {
        lblGameName.setText(name);
    }

    public void setLibrary(String library) {
        lblLibraryValue.setText(library);
    }

    public void setCategory(String category) {
        lblCategoryValue.setText(category);
    }

    public void setPlatform(String platform) {
        lblPlatformValue.setText(platform);
    }

    public void setCompleted(int completed) {
        if(completed == 1) lblStateValue.setText("COMPLETADO");
        else lblStateValue.setText("NO COMPLETADO");
    }
}
