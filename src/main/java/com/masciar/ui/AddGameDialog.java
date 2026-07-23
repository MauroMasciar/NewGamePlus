package com.masciar.ui;

import com.masciar.util.Utils;
import com.masciar.util.Validations;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeListener;
import com.raven.datechooser.DateChooser;

public class AddGameDialog extends JDialog {
    private final JPanel pnlDetails = new JPanel();
    private final JLabel lblTitle = new JLabel("Titulo:");
    private final JLabel lblReleaseDate = new JLabel("Fecha de lanzamiento:");
    private final JLabel lblRating = new JLabel(" Rating:");
    private final JLabel lblGenre = new JLabel("Género:");
    private final JLabel lblPlatform = new JLabel(" Plataforma:");
    private final JLabel lblDeveloper = new JLabel("Desarrollador:");
    private final JLabel lblPublisher = new JLabel(" Publicador:");
    private final JLabel lblSeries = new JLabel("Serie:");
    private final JLabel lblRegion = new JLabel(" Región:");
    private final JLabel lblPlayMode = new JLabel("Modo de juego:");
    private final JLabel lblVersion = new JLabel(" Versión:");
    private final JLabel lblStatus = new JLabel("Estado:");
    private final JLabel lblLibrary = new JLabel("Biblioteca:");
    private final JLabel lblLastPlayed = new JLabel("Ultima sesión:");
    private final JLabel lblAdded = new JLabel(" Añadido:");
    private final JLabel lblModified = new JLabel(" Modificado:");
    private final JLabel lblGameTime = new JLabel(" Tiempo jugado:");
    private final JLabel lblCompletedDate = new JLabel(" Fecha de completado:");
    private final JLabel lblPlayCount = new JLabel(" Veces jugado:");
    private final JLabel lblConvertedSeconds = new JLabel(" (00h 00m 00s)");
    private final JLabel lblPath = new JLabel("Ejecutable:");
    private final JLabel lblScore = new JLabel(" Puntaje:");
    private final JLabel lblCategory = new JLabel("Categoria:");
    private final JTextField txtGameName = new JTextField(20);
    private final JTextField txtReleaseDate = new JTextField(20);
    private final JTextField txtGenre = new JTextField(10);
    private final JComboBox<String> cbPlatform = new JComboBox<>();
    private final JTextField txtDeveloper = new JTextField(10);
    private final JTextField txtPublisher = new JTextField(10);
    private final JTextField txtSeries = new JTextField(10);
    private final JTextField txtRegion = new JTextField(10);
    private final JTextField txtPlayMode = new JTextField(10);
    private final JTextField txtVersion = new JTextField(10);
    private final JTextField txtStatus = new JTextField(10);
    private final JTextField txtLastPlayed = new JTextField(10);
    private final JTextField txtAdded = new JTextField(10);
    private final JTextField txtModified = new JTextField(10);
    private final JTextField txtPath = new JTextField(10);
    private final JTextField txtCompletedDate = new JTextField(10);
    private final JTextField txtPlayCount = new JTextField();
    private final JCheckBox chFavorite = new JCheckBox("Favorito");
    private final JCheckBox chCompleted = new JCheckBox("Completado");
    private final JCheckBox chStatistic = new JCheckBox("Estadísticas");
    private final JCheckBox chGhost = new JCheckBox("Fantasma");
    private final JCheckBox chPortable = new JCheckBox("Portable");
    private final JCheckBox chHide = new JCheckBox("Oculto");
    private final JComboBox<String> cbRating = new JComboBox<>();
    private final JComboBox<String> cbCategory = new JComboBox<>();
    private final JComboBox<String> cbLibrary = new JComboBox<>();
    private final SpinnerNumberModel spinnerNumberModelScore = new SpinnerNumberModel();
    private final SpinnerNumberModel spinnerNumberModelGameTime = new SpinnerNumberModel();
    private final JSpinner spinScore = new JSpinner();
    private final JSpinner spinGameTime = new JSpinner();
    private final JPanel pnlNotes = new JPanel();
    private final JTextArea txtaNotes = new JTextArea();
    private final JScrollPane scrNotes = new JScrollPane(txtaNotes);
    private final DateChooser dcCompletedDate = new DateChooser();
    private final DateChooser dcReleaseDate = new DateChooser();
    private final JButton btnSave = new JButton("Guardar");

    public AddGameDialog(MainWindow window, boolean modal) {
        super(window, true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Añadir nuevo juego");

        initComponents();
    }

    public void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void showInfo(String message) {
        JOptionPane.showMessageDialog(this, message, "Información", JOptionPane.INFORMATION_MESSAGE);
    }

    public void showPopupCompletedDateListener(ActionListener listener) {
        txtCompletedDate.addActionListener(listener);
    }

    public void showPopupReleaseDateListener(ActionListener listener) {
        txtReleaseDate.addActionListener(listener);
    }

    public void setBtnSaveListener(ActionListener listener) {
        btnSave.addActionListener(listener);
    }

    public void setLblConvertedSeconds(String text) {
        lblConvertedSeconds.setText(text);
    }

    public void setSpinGameTimeListener(ChangeListener listener) {
        spinGameTime.addChangeListener(listener);
    }

    public void fillComboBoxCategory(String value) {
        cbCategory.addItem(value);
    }

    public void fillComboBoxLibrary(String value) {
        cbLibrary.addItem(value);
    }

    public void filLComboBoxPlatform(String value) {
        cbPlatform.addItem(value);
    }

    public void showPopupCompletedDate() {
        dcCompletedDate.showPopup();
    }

    public void showPopupReleaseDate() {
        dcReleaseDate.showPopup();
    }

    public String getTxtNameString() {
        return txtGameName.getText();
    }

    public String getTxtReleaseDate() {
        return txtReleaseDate.getText();
    }

    public String getTxtDeveloper() {
        return txtDeveloper.getText();
    }

    public String getTxtPublisher() {
        return txtPublisher.getText();
    }

    public String getTxtSeries() {
        return txtSeries.getText();
    }

    public String getTxtStatus() {
        return txtStatus.getText();
    }

    public String getTxtPlayMode() {
        return txtPlayMode.getText();
    }

    public String getTxtVersion() {
        return txtVersion.getText();
    }

    public String getTxtRegion() {
        return txtRegion.getText();
    }

    public String getTxtPath() {
        return txtPath.getText();
    }

    public String getTxtCompletedDateString() {
        return txtCompletedDate.getText();
    }

    public String getTxtLastPlayed() {
        return txtLastPlayed.getText();
    }

    public String getTxtaNotes() {
        return txtaNotes.getText();
    }

    public boolean getFavoriteState() {
        if(chFavorite.isSelected()) return true;
        else return false;
    }

    public boolean getCompletedState() {
        if(chCompleted.isSelected()) return true;
        else return false;
    }

    public boolean getStatisticState() {
        if(chStatistic.isSelected()) return true;
        else return false;
    }

    public boolean getPortableState() {
        if(chPortable.isSelected()) return true;
        else return false;
    }

    public boolean getHideState() {
        if(chHide.isSelected()) return true;
        else return false;
    }

    public String getRatingValueString() {
        return cbRating.getSelectedItem().toString();
    }

    public String getCbPlatformString() {
        return cbPlatform.getSelectedItem().toString();
    }

    public String getCbLibraryString() {
        return cbLibrary.getSelectedItem().toString();
    }

    public String getCbCategoryString() {
        return cbCategory.getSelectedItem().toString();
    }

    public int getSpinScoreValue() {
        return Integer.parseInt(spinScore.getValue().toString());
    }

    public int getSpinGameTimeValue() {
        return Integer.parseInt(spinGameTime.getValue().toString());
    }

    public void initComponents() {
        setLayout(new GridBagLayout());
        
        pnlDetails.setLayout(new GridBagLayout());
        pnlDetails.setBorder(BorderFactory.createTitledBorder("Detalles"));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.ipadx = 8;
        gbc.ipady = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        pnlDetails.add(lblTitle, gbc);
        gbc.gridx++;
        gbc.gridwidth = 7;
        pnlDetails.add(txtGameName, gbc);
        gbc.gridwidth = 1;
        gbc.weightx = 1.0;
        gbc.gridx = 0;
        gbc.gridy++;
        pnlDetails.add(lblReleaseDate, gbc);
        gbc.gridx++;
        gbc.gridwidth = 3;
        pnlDetails.add(txtReleaseDate, gbc);
        gbc.gridx += 3;
        gbc.gridwidth = 1;
        pnlDetails.add(lblRating, gbc);
        gbc.gridx++;
        gbc.gridwidth = 3;
        pnlDetails.add(cbRating, gbc);
        gbc.gridwidth = 1;
        gbc.weightx = 1.0;
        gbc.gridx = 0;
        gbc.gridy++;
        pnlDetails.add(lblGenre, gbc);
        gbc.gridx++;
        gbc.gridwidth = 3;
        pnlDetails.add(txtGenre, gbc);
        gbc.gridx += 3;
        gbc.gridwidth = 1;
        pnlDetails.add(lblPlatform, gbc);
        gbc.gridx++;
        gbc.gridwidth = 3;
        pnlDetails.add(cbPlatform, gbc);
        gbc.gridwidth = 1;
        gbc.weightx = 1.0;
        gbc.gridx = 0;
        gbc.gridy++;
        pnlDetails.add(lblDeveloper, gbc);
        gbc.gridx++;
        gbc.gridwidth = 3;
        pnlDetails.add(txtDeveloper, gbc);
        gbc.gridx += 3;
        gbc.gridwidth = 1;
        pnlDetails.add(lblPublisher, gbc);
        gbc.gridx++;
        gbc.gridwidth = 3;
        pnlDetails.add(txtPublisher, gbc);
        gbc.gridwidth = 1;
        gbc.weightx = 1.0;
        gbc.gridx = 0;
        gbc.gridy++;
        pnlDetails.add(lblSeries, gbc);
        gbc.gridx++;
        gbc.gridwidth = 3;
        pnlDetails.add(txtSeries, gbc);
        gbc.gridx += 3;
        gbc.gridwidth = 1;
        pnlDetails.add(lblRegion, gbc);
        gbc.gridx++;
        gbc.gridwidth = 3;
        pnlDetails.add(txtRegion, gbc);
        gbc.gridwidth = 1;
        gbc.weightx = 1.0;
        gbc.gridx = 0;
        gbc.gridy++;
        pnlDetails.add(lblPlayMode, gbc);
        gbc.gridx++;
        gbc.gridwidth = 3;
        pnlDetails.add(txtPlayMode, gbc);
        gbc.gridx += 3;
        gbc.gridwidth = 1;
        pnlDetails.add(lblVersion, gbc);
        gbc.gridx++;
        gbc.gridwidth = 3;
        pnlDetails.add(txtVersion, gbc);
        gbc.gridwidth = 1;
        gbc.weightx = 1.0;
        gbc.gridx = 0;
        gbc.gridy++;
        pnlDetails.add(lblStatus, gbc);
        gbc.gridx++;
        gbc.gridwidth = 3;
        pnlDetails.add(txtStatus, gbc);
        gbc.gridx += 3;
        gbc.gridwidth = 1;
        pnlDetails.add(lblAdded, gbc);
        gbc.gridx++;
        gbc.gridwidth = 1;
        pnlDetails.add(txtAdded, gbc);
        gbc.gridx++;
        pnlDetails.add(chFavorite, gbc);
        gbc.gridx++;
        pnlDetails.add(chPortable, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        pnlDetails.add(lblLibrary, gbc);
        gbc.gridx++;
        gbc.gridwidth = 3;
        pnlDetails.add(cbLibrary, gbc);
        gbc.gridx += 3;
        gbc.gridwidth = 1;
        pnlDetails.add(lblModified, gbc);
        gbc.gridx++;
        pnlDetails.add(txtModified, gbc);
        gbc.gridx++;
        pnlDetails.add(chCompleted, gbc);
        gbc.gridx++;
        pnlDetails.add(chHide, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        pnlDetails.add(lblLastPlayed, gbc);
        gbc.gridx++;
        gbc.gridwidth = 3;
        pnlDetails.add(txtLastPlayed, gbc);
        gbc.gridx += 3;
        gbc.gridwidth = 1;
        pnlDetails.add(lblCompletedDate, gbc);
        gbc.gridx++;
        pnlDetails.add(txtCompletedDate, gbc);
        gbc.gridx++;
        pnlDetails.add(chStatistic, gbc);
        gbc.gridx++;
        pnlDetails.add(chGhost, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        pnlDetails.add(lblPath, gbc);
        gbc.gridx++;
        gbc.gridwidth = 3;
        pnlDetails.add(txtPath, gbc);
        gbc.gridwidth = 1;
        gbc.gridx += 3;
        pnlDetails.add(lblGameTime, gbc);
        gbc.gridx++;
        pnlDetails.add(spinGameTime, gbc);
        gbc.gridx++;
        pnlDetails.add(lblConvertedSeconds, gbc);	
        gbc.gridy++;
        gbc.gridx = 0;
        pnlDetails.add(lblCategory, gbc);
        gbc.gridx++;
        gbc.gridwidth = 3;
        pnlDetails.add(cbCategory, gbc);
        gbc.gridx += 3;
        gbc.gridwidth = 1;
        pnlDetails.add(lblPlayCount, gbc);
        gbc.gridx++;
        pnlDetails.add(txtPlayCount, gbc);
        gbc.gridx++;
        pnlDetails.add(lblScore, gbc);
        gbc.gridx++;
        pnlDetails.add(spinScore, gbc);
        
        // Panel notes
        pnlNotes.setLayout(new GridBagLayout());
        pnlNotes.setBorder(BorderFactory.createTitledBorder("Notas"));
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.ipadx = 1;
        gbc.ipady = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        pnlNotes.add(scrNotes, gbc);
        setLayout(new GridBagLayout());
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.ipadx = 1;
        gbc.ipady = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(pnlDetails, gbc);
        gbc.gridy++;
        gbc.gridheight = 2;
        gbc.gridwidth = 2;
        gbc.weightx = 2.0;
        gbc.weighty = 2.0;
        add(pnlNotes, gbc);
        gbc.gridy += 2;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.NONE;
        add(btnSave, gbc);

        chGhost.setToolTipText("Especifica si quieres iniciar el juego manualmente en vez de que lo inicie la aplicación");
        txtPath.setToolTipText("Especifica la ruta completa al ejecutable");
        chStatistic.setToolTipText("Especifica si quieres que este juego aparezca en las estadísticas");

        spinnerNumberModelScore.setMinimum(0);
        spinnerNumberModelScore.setMaximum(100);
        spinnerNumberModelGameTime.setMinimum(0);
        spinScore.setModel(spinnerNumberModelScore);
        spinGameTime.setModel(spinnerNumberModelGameTime);
        txtAdded.setText(Utils.getFormattedDate());
        txtModified.setText(Utils.getFormattedDateTime());

        txtGenre.setEditable(false);
        txtPlayCount.setEditable(false);
        txtLastPlayed.setEditable(false);
        
        txtGenre.setVisible(false);
        lblGenre.setVisible(false);

        dcCompletedDate.setDateFormat("yyyy-MM-dd");
        dcCompletedDate.setTextRefernce(txtCompletedDate);
        dcCompletedDate.hidePopup();
        dcReleaseDate.setDateFormat("yyyy-MM-dd");
        dcReleaseDate.setTextRefernce(txtReleaseDate);
        dcReleaseDate.hidePopup();
        dcCompletedDate.setSelectedDate(new Date(System.currentTimeMillis()));
        dcReleaseDate.setSelectedDate(new Date(System.currentTimeMillis()));
        
        txtPlayCount.setText("0");

        chGhost.setSelected(true);

        if(Validations.isEmpty(txtReleaseDate)) txtReleaseDate.setText("1900-01-01");
        if(Validations.isEmpty(txtLastPlayed)) txtLastPlayed.setText("1900-01-01 00:00:00");

        txtAdded.setEditable(false);
        txtModified.setEditable(false);
        txtaNotes.setLineWrap(true);
        txtaNotes.setWrapStyleWord(true);

        loadRating();
    }

    public void loadRating() {
        cbRating.addItem("E - Everyone");
        cbRating.addItem("E10+ - Everyone 10+");
        cbRating.addItem("T - Teen");
        cbRating.addItem("M - Mature 17+");
        cbRating.addItem("A - Adults Only 18+");
        cbRating.addItem("EC - Early Childhood");
        cbRating.addItem("RP - Rating Pending");
    }
}