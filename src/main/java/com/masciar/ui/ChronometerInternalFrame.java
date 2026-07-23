package com.masciar.ui;

import com.masciar.util.Utils;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import javax.swing.JInternalFrame;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

public class ChronometerInternalFrame extends JInternalFrame {
	private JLabel lblSeparator = new JLabel("_____________________________________________");
	private JLabel lblSeparator2 = new JLabel("_____________________________________________");
	private JLabel lblSeparator3 = new JLabel("_____________________________________________");
	private JLabel lblGameName = new JLabel("Nombre del juego");
	private JLabel lblSessionStatus = new JLabel("\u25CF Sesión activa");
	private JLabel lblTime = new JLabel("0h 00m 00s");
	private JLabel lblInfoTime = new JLabel("Tiempo jugado efectivo");
	private JLabel lblInitDate = new JLabel("Iniciado a las 00:00 hace 0h 0m");
	private JButton btnPause = new JButton("Pausar");
	private JButton btnStop = new JButton("Finalizar sesión");
	private JLabel lblStats = new JLabel("ESTADÍSTICAS DE LA SESIÓN");
	private JLabel lblPauses = new JLabel("Pausas");
	private JLabel lblPausesValue = new JLabel("0");
	private JLabel lblPauseTime = new JLabel("Tiempo en pausa");
	private JLabel lblPauseTimeValue = new JLabel("0h 00m 00s");
	private JLabel lblTotalTime = new JLabel("Tiempo total");
	private JLabel lblTotalTimeValue = new JLabel("0h 00m 00s");
	private JLabel lblMedTimeSession = new JLabel("Media por sesión");
	private JLabel lblMedTimeSessionValue = new JLabel("0h 00m 00s");
	private JLabel lblTotalPlayedGame = new JLabel("Tiempo total jugado");
	private JLabel lblTotalPlayedGameValue = new JLabel("00:00");
	private JLabel lblPlayCount = new JLabel("Veces iniciado");
	private JLabel lblPlayCountValue = new JLabel("0");	
	private JLabel lblInfoFuture = new JLabel("Con esta sesión llegarás a");
	private JLabel lblInfoFutureTime = new JLabel("0h 0m");
	private JLabel lblInfoFutureFooter = new JLabel("tiempo total jugado");
	
    public ChronometerInternalFrame() {
        setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
    	initComponents();
		setVisible(true);
    }

    public void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void showInfo(String message) {
        JOptionPane.showMessageDialog(this, message, "Información", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void strobe(boolean pause) {
        if(pause) {
            lblSessionStatus.setText("\u25CF Sesión no activa");
            if(lblSessionStatus.getForeground().equals(Color.decode(Utils.COLOR_GREEN))) {
                lblSessionStatus.setForeground(Color.RED);
                lblTime.setForeground(Color.RED);
            } else {
                lblSessionStatus.setForeground(Color.decode(Utils.COLOR_GREEN));
                lblTime.setForeground(Color.decode(Utils.COLOR_GREEN));
            }
        } else {
            lblSessionStatus.setText("\u25CF Sesión activa");
            lblSessionStatus.setForeground(Color.decode(Utils.COLOR_GREEN));
            lblTime.setForeground(Color.decode(Utils.COLOR_GREEN));
        }
	}

    public void setTime(String seconds) {
        lblTime.setText(seconds);
    }

    public void setTimeTotal(String seconds) {
        lblTotalTimeValue.setText(seconds);
    }

    public void setTimePaused(String seconds) {
        lblPauseTimeValue.setText(seconds);
    }

    public void setGameName(String name) {
        lblGameName.setText(name);
    }
    
    public void setPlayCount(String text) {
        lblPlayCountValue.setText(text);
    }

    public void setTotalPlayed(String text) {
        lblTotalPlayedGameValue.setText(text);
    }

    public void setTotalPlayedAfterSession(String text) {
        lblInfoFutureTime.setText(text);
    }

    public void setTotalFutureTime(String text) {
        lblInfoFutureTime.setText(text);
    }

    public void setAgeSession(String text) {
        lblInitDate.setText(text);
    }

    public void setAvgTimePlayed(String text) {
        lblMedTimeSessionValue.setText(text);
    }

    public void btnPauseText(String text) {
        btnPause.setText(text);
    }

    public void setPauseCount(String text) {
        lblPausesValue.setText(text);
    }

    public void setBtnPauseListener(ActionListener listener) {
        btnPause.addActionListener(listener);
    }

    public void setBtnStopListener(ActionListener listener) {
        btnStop.addActionListener(listener);
    }

	public void initComponents() {
        setResizable(false);
        setLayout(new BorderLayout(10, 10));
        
        lblSeparator.setForeground(Color.GRAY);
        lblSeparator2.setForeground(Color.GRAY);
        lblSeparator3.setForeground(Color.GRAY);
        lblGameName.setFont(new Font("Arial", Font.BOLD, 22));
        lblGameName.setForeground(Color.WHITE);
        lblSessionStatus.setFont(new Font("Arial", Font.BOLD, 16));
        lblSessionStatus.setForeground(Color.decode(Utils.COLOR_GREEN));
        lblTime.setFont(new Font("Arial", Font.BOLD, 50));
        lblTime.setForeground(Color.decode(Utils.COLOR_GREEN));
        lblInfoTime.setFont(new Font("Arial", Font.BOLD, 12));
        lblInitDate.setFont(new Font("Arial", Font.BOLD, 10));
        lblTotalPlayedGame.setFont(new Font("Arial", Font.BOLD, 14));
        lblTotalPlayedGameValue.setFont(new Font("Arial", Font.BOLD, 14));
        
        btnStop.setBackground(Color.RED);
        btnPause.setFont(new Font("Arial", Font.BOLD, 24));
        btnStop.setFont(new Font("Arial", Font.BOLD, 24));
        
        JPanel pnlLeft = new JPanel();
        JPanel pnlRight = new JPanel();
        GridBagConstraints left = new GridBagConstraints();
        GridBagConstraints right = new GridBagConstraints();
        pnlLeft.setLayout(new GridBagLayout());
        pnlRight.setLayout(new GridBagLayout());
        
        // Panel izquierdo
        left.gridheight = 1;
        left.gridwidth = 2;
        left.weightx = 1.0;
        left.weighty = 0;
        left.ipadx = 1;
        left.ipady = 1;
        left.fill = GridBagConstraints.NONE;
        left.insets = new Insets(4, 4, 4, 4);
        left.anchor = GridBagConstraints.WEST;
        left.gridy = 0;
        left.gridx = 0;
        
        pnlLeft.add(lblGameName, left);
        left.gridy++;
        pnlLeft.add(lblSessionStatus, left);
        left.gridy++;
        pnlLeft.add(lblSeparator, left);
        left.anchor = GridBagConstraints.CENTER;
        left.gridy++;
        pnlLeft.add(lblTime, left);
        left.gridy++;
        pnlLeft.add(lblInfoTime, left);
        left.gridy++;
        pnlLeft.add(lblSeparator3, left);
        left.gridy++;
        pnlLeft.add(lblInitDate, left);
        left.anchor = GridBagConstraints.WEST;
        left.gridy++;
        pnlLeft.add(lblSeparator2, left);
        left.gridy++;
        left.fill = GridBagConstraints.HORIZONTAL;
        pnlLeft.add(btnPause, left);
        left.gridy++;
        pnlLeft.add(btnStop, left);        
        
        lblStats.setFont(new Font("Arial", Font.BOLD, 16));
        lblStats.setForeground(Color.GRAY);
        lblPauses.setFont(new Font("Arial", Font.BOLD, 14));
        lblPausesValue.setFont(new Font("Arial", Font.BOLD, 14));
        lblPauseTime.setFont(new Font("Arial", Font.BOLD, 14));
        lblPauseTimeValue.setFont(new Font("Arial", Font.BOLD, 14));
        lblTotalTime.setFont(new Font("Arial", Font.BOLD, 14));
        lblTotalTimeValue.setFont(new Font("Arial", Font.BOLD, 14));
        lblMedTimeSession.setFont(new Font("Arial", Font.BOLD, 14));
        lblMedTimeSessionValue.setFont(new Font("Arial", Font.BOLD, 14));
        lblPlayCount.setFont(new Font("Arial", Font.BOLD, 14));
        lblPlayCountValue.setFont(new Font("Arial", Font.BOLD, 14));
        lblInfoFuture.setHorizontalAlignment(JLabel.CENTER);
        lblInfoFutureTime.setHorizontalAlignment(JLabel.CENTER);
        lblInfoFutureFooter.setHorizontalAlignment(JLabel.CENTER);
        lblInfoFuture.setFont(new Font("Arial", Font.BOLD, 18));
    	lblInfoFutureTime.setFont(new Font("Arial", Font.BOLD, 28));
    	lblInfoFutureFooter.setFont(new Font("Arial", Font.BOLD, 18));
    	lblInfoFutureTime.setForeground(Color.decode(Utils.COLOR_GREEN));
        
        // Panel derecho
        right.gridheight = 1;
        right.gridwidth = 1;
        right.weightx = 1.0;
        right.weighty = 0;
        right.fill = GridBagConstraints.HORIZONTAL;
        right.insets = new Insets(6, 28, 6, 12);
        right.anchor = GridBagConstraints.EAST;
        right.gridy = 0;
        right.gridx = 0;
        
        JPanel pnlTitle = new JPanel(new BorderLayout());
        pnlTitle.add(lblStats);
        pnlRight.add(pnlTitle, right);
        
        right.gridy++;
        
        JPanel pnlPauses = new JPanel(new BorderLayout());
        pnlPauses.add(lblPauses, BorderLayout.WEST);
        pnlPauses.add(lblPausesValue, BorderLayout.EAST);
        pnlRight.add(pnlPauses, right);
        
        right.gridy++;
        JPanel pnlPausesTime = new JPanel(new BorderLayout());
        pnlPausesTime.add(lblPauseTime, BorderLayout.WEST);
        pnlPausesTime.add(lblPauseTimeValue, BorderLayout.EAST);
        pnlRight.add(pnlPausesTime, right);
        
        right.gridy++;
        JPanel pnlTotalTime = new JPanel(new BorderLayout());
        pnlTotalTime.add(lblTotalTime, BorderLayout.WEST);
        pnlTotalTime.add(lblTotalTimeValue, BorderLayout.EAST);
        pnlRight.add(pnlTotalTime, right);
        
        right.gridy++;
        JPanel pnlMedTimeSession = new JPanel(new BorderLayout());
        pnlMedTimeSession.add(lblMedTimeSession, BorderLayout.WEST);
        pnlMedTimeSession.add(lblMedTimeSessionValue, BorderLayout.EAST);
        pnlRight.add(pnlMedTimeSession, right);
        
        right.gridy++;
        JPanel pnlPlayCount = new JPanel(new BorderLayout());
        pnlPlayCount.add(lblPlayCount, BorderLayout.WEST);
        pnlPlayCount.add(lblPlayCountValue, BorderLayout.EAST);
        pnlRight.add(pnlPlayCount, right);
        
        right.gridy++;
        JPanel pnlTotalPlayedGame = new JPanel(new BorderLayout());
        pnlTotalPlayedGame.add(lblTotalPlayedGame, BorderLayout.WEST);
        pnlTotalPlayedGame.add(lblTotalPlayedGameValue, BorderLayout.EAST);
        pnlRight.add(pnlTotalPlayedGame, right);
        
        right.gridy++;
        JPanel pnlInfoFuture = new JPanel(new BorderLayout());
        pnlInfoFuture.add(lblInfoFuture, BorderLayout.NORTH);
        pnlInfoFuture.add(lblInfoFutureTime, BorderLayout.CENTER);
        pnlInfoFuture.add(lblInfoFutureFooter, BorderLayout.SOUTH);
        pnlRight.add(pnlInfoFuture, right);
        pnlInfoFuture.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        
        Border linea = BorderFactory.createLineBorder(Color.DARK_GRAY, 1);
        Border margen = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        
        pnlLeft.setBorder(BorderFactory.createCompoundBorder(linea, margen));
        pnlRight.setBorder(BorderFactory.createCompoundBorder(linea, margen));
        
        margen = BorderFactory.createEmptyBorder(2, 5, 2, 5);
        
        pnlPauses.setBorder(BorderFactory.createCompoundBorder(linea, margen));
        pnlPausesTime.setBorder(BorderFactory.createCompoundBorder(linea, margen));
        pnlTotalTime.setBorder(BorderFactory.createCompoundBorder(linea, margen));
        pnlMedTimeSession.setBorder(BorderFactory.createCompoundBorder(linea, margen));
        pnlPlayCount.setBorder(BorderFactory.createCompoundBorder(linea, margen));
        pnlTotalPlayedGame.setBorder(BorderFactory.createCompoundBorder(linea, margen));
        pnlInfoFuture.setBorder(BorderFactory.createCompoundBorder(linea, margen));
        
    	add(pnlLeft, BorderLayout.WEST);
    	add(pnlRight, BorderLayout.EAST);
    	
    	FlatSVGIcon icon = new FlatSVGIcon("resources/icons/player-pause.svg", 32, 32);
    	icon.setColorFilter(new FlatSVGIcon.ColorFilter(color -> Color.WHITE));
    	btnPause.setIcon(icon);
    	
    	icon = new FlatSVGIcon("resources/icons/player-stop.svg", 32, 32);
    	icon.setColorFilter(new FlatSVGIcon.ColorFilter(color -> Color.WHITE));
    	btnStop.setIcon(icon);

        pack();
	}
}
