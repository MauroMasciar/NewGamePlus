package com.masciar.ui;

import com.masciar.app.Main;
import com.masciar.controller.AddGameController;
import com.masciar.controller.AddSessionManuallyController;
import com.masciar.controller.GameInfoController;
import com.masciar.controller.GeneralSummaryController;
import com.masciar.controller.PlayerStatisticsController;
import com.masciar.service.ConfigService;
import com.masciar.controller.ConfigController;
import com.masciar.controller.EditGameController;

import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;

public class MainWindow extends JFrame implements ActionListener, WindowStateListener {
    private static final long serialVersionUID = 1092418710020581973L;
    private final JMenuBar menubar = new JMenuBar();
    private final JMenu mnuGames = new JMenu("Juegos");
    private final JMenuItem mnuiGamesAdd = new JMenuItem("Nuevo", new ImageIcon("/resources/icons/new_game.png"));
    private final JMenuItem mnuiGamesEdit = new JMenuItem("Editar");
    private final JMenuItem mnuiGamesList = new JMenuItem("Ver biblioteca", new ImageIcon("/resources/icons/games_list.png"));
    private final JMenuItem mnuiGamesWishlist = new JMenuItem("Ver lista de deseos");
    private final JMenu mnuiGamesView = new JMenu("Ver");
    private final JCheckBoxMenuItem mnuiGamesHidden = new JCheckBoxMenuItem("Ver ocultos");
    private final JCheckBoxMenuItem mnuiViewGamesInit = new JCheckBoxMenuItem("Ver solo iniciados");
    private final JCheckBoxMenuItem mnuiGamesOrderByDate = new JCheckBoxMenuItem("Ordenar por última vez");
    private final JMenu mnuPlayerStatistics = new JMenu("Estadísticas");
    private final JMenuItem mnuiPlayerViewStatistics = new JMenuItem("Ver estadisticas");
    private final JMenuItem mnuiPlayerStatisticsPlayCount = new JMenuItem("Sesiones");
    private final JMenuItem mnuiPlayerStatisticsTotalHours = new JMenuItem("Tiempo");
    private final JMenu mnuPlayer = new JMenu("Jugador");
    private final JMenuItem mnuiPlayerAddSession = new JMenuItem("Añadir sesión", new ImageIcon("/resources/icons/new_session.png"));
    private final JMenuItem mnuiPlayerAddAchiev = new JMenuItem("Añadir hazaña", new ImageIcon("/resources/icons/x.png"));
    private final JMenuItem mnuiPlayerActivities = new JMenuItem("Actividad", new ImageIcon("/resources/icons/history.png"));
    private final JMenuItem mnuiPlayerNotes = new JMenuItem("Notas", new ImageIcon("/resources/icons/notes.png"));
    private final JMenuItem mnuiPlayerHistory = new JMenuItem("Historial", new ImageIcon("/resources/icons/activity.png"));
    private final JMenu mnuData = new JMenu("Datos");
    private final JMenuItem mnuiDataCategory = new JMenuItem("Categorías", new ImageIcon("/resources/icons/category.png"));
    private final JMenuItem mnuiDataCollections = new JMenuItem("Colecciones", new ImageIcon("/resources/icons/collections.png"));
    private final JMenuItem mnuiDataLibrary = new JMenuItem("Bibliotecas", new ImageIcon("/resources/icons/library.png"));
    private final JMenuItem mnuiDataPlatforms = new JMenuItem("Plataformas", new ImageIcon("/resources/icons/library.png"));
    private final JMenuItem mnuiDataRefresh = new JMenuItem("Actualizar", new ImageIcon("/resources/icons/refresh.png"));
    private final JMenuItem mnuiDataRating = new JMenuItem("Rating");
    private final JMenu mnuUtils = new JMenu("Utilidades");
    private final JMenuItem mnuiItemsCronometer = new JMenuItem("Cronometro");
    private final JMenuItem mnuiItemsTimer = new JMenuItem("Temporizador");
    private final JMenu mnuHelp = new JMenu("Ayuda");
    private final JMenuItem mnuiHelpConfig = new JMenuItem("Configuración", new ImageIcon("/resources/icons/config.png"));
    private final JMenuItem mnuiHelpUpdate = new JMenuItem("Actualizar", new ImageIcon("/resources/icons/update.png"));
    private final JMenuItem mnuiHelpAbout = new JMenuItem("Acerca de", new ImageIcon("/resources/icons/about.png"));
    private final JMenuItem mnuiHelpDebug = new JMenuItem("Debug", new ImageIcon("/resources/icons/debug.png"));
    private final JMenuItem mnuiGamesExit = new JMenuItem("Salir");
    private JDesktopPane desktopPane;

    // Ventanas
    private static GamesList gamesList;
    private static GeneralSummaryController generalSummaryController;
    private static GameInfoController gameInfoController;
    private static PlayerStatisticsController playerStatisticsController;

    public MainWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String title = "NewGame+ — Game Session Tracker — " + Main.VERSION_APP;
        setTitle(title);
        try {
            setIconImage(new ImageIcon(getClass().getResource("/resources/icons/icon.png")).getImage());
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(this, "No se han podido cargar algunos recursos", "Error", JOptionPane.ERROR_MESSAGE);
        }
        setBounds(30, 30, 1400, 900);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        try {
            if (ConfigService.getProperty("WindowMaximized").equals("1"))
                setExtendedState(JFrame.MAXIMIZED_BOTH);
        } catch (NullPointerException e) {
            ConfigService.setProperty("WindowMaximized", "0");
        }

        setLayout(new FlowLayout());
        desktopPane = new JDesktopPane();
        setContentPane(desktopPane);

        addWindowStateListener(this);

        initComponents();

        gamesList = new GamesList(desktopPane);
        desktopPane.add(gamesList);
        desktopPane.add(new SessionsHistory());

        gameInfoController = new GameInfoController(this);
        gamesList.setListener(gameInfoController);

        generalSummaryController = new GeneralSummaryController(desktopPane);
        playerStatisticsController = new PlayerStatisticsController(desktopPane);

        setVisible(true);
    }

    public static void refreshOpenViews() {
        if (generalSummaryController != null)
            generalSummaryController.refresh();

        if (gameInfoController != null)
            gameInfoController.update();

        if (playerStatisticsController != null)
            playerStatisticsController.update();

        if (gamesList != null)
            gamesList.refreshList();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mnuiGamesAdd) {
            @SuppressWarnings("unused")
            AddGameController addGameController = new AddGameController(this);
        } else if (e.getSource() == mnuiGamesEdit) {
            @SuppressWarnings("unused")
            EditGameController editGameController = new EditGameController(this, gameInfoController.getGameSelected());
        } else if (e.getSource() == mnuiPlayerAddSession) {
            @SuppressWarnings("unused")
            AddSessionManuallyController addSessionController = new AddSessionManuallyController(this);
        } else if (e.getSource() == mnuiHelpAbout) {
            @SuppressWarnings("unused")
            About about = new About(this, true);
        } else if (e.getSource() == mnuiHelpConfig) {
            @SuppressWarnings("unused")
            ConfigController configController = new ConfigController(desktopPane);
        }
    }

    @Override
    public void windowStateChanged(WindowEvent e) {
        int oldState = e.getOldState();
        int newState = e.getNewState();

        if ((oldState & 6) == 0 && (newState & 6) != 0) {
            ConfigService.setProperty("WindowMaximized", "1");
        } else if ((newState & 6) == 0 && (oldState & 6) != 0) {
            ConfigService.setProperty("WindowMaximized", "0");
        }
    }

    private void initComponents() {
        createMenuBar();
    }

    private void createMenuBar() {
        menubar.add(mnuGames);
        menubar.add(mnuPlayer);
        menubar.add(mnuData);
        menubar.add(mnuUtils);
        menubar.add(mnuHelp);
        mnuGames.add(mnuiGamesAdd);
        mnuGames.add(mnuiGamesEdit);
        mnuGames.add(mnuiGamesList);
        mnuGames.add(mnuiGamesWishlist);
        mnuGames.add(mnuiGamesView);
        mnuGames.addSeparator();
        mnuGames.add(mnuiGamesExit);
        mnuiGamesView.add(mnuiGamesOrderByDate);
        mnuiGamesView.add(mnuiGamesHidden);
        mnuiGamesView.add(mnuiViewGamesInit);
        mnuPlayer.add(mnuiPlayerAddSession);
        mnuPlayer.add(mnuiPlayerAddAchiev);
        mnuPlayer.add(mnuiPlayerHistory);
        mnuPlayer.add(mnuiPlayerActivities);
        mnuPlayer.add(mnuiPlayerNotes);
        mnuPlayer.add(mnuPlayerStatistics);
        mnuPlayerStatistics.add(mnuiPlayerViewStatistics);
        mnuPlayerStatistics.add(mnuiPlayerStatisticsPlayCount);
        mnuPlayerStatistics.add(mnuiPlayerStatisticsTotalHours);
        mnuData.add(mnuiDataCategory);
        mnuData.add(mnuiDataCollections);
        mnuData.add(mnuiDataLibrary);
        mnuData.add(mnuiDataPlatforms);
        mnuData.add(mnuiDataRating);
        mnuData.addSeparator();
        mnuData.add(mnuiDataRefresh);
        mnuUtils.add(mnuiItemsCronometer);
        mnuUtils.add(mnuiItemsTimer);
        mnuHelp.add(mnuiHelpConfig);
        mnuHelp.add(mnuiHelpDebug);
        mnuHelp.add(mnuiHelpUpdate);
        mnuHelp.addSeparator();
        mnuHelp.add(mnuiHelpAbout);

        mnuiGamesExit.addActionListener(this);
        mnuiDataRefresh.addActionListener(this);
        mnuiGamesAdd.addActionListener(this);
        mnuiGamesEdit.addActionListener(this);
        mnuiGamesOrderByDate.addActionListener(this);
        mnuiGamesList.addActionListener(this);
        mnuiGamesHidden.addActionListener(this);
        mnuiViewGamesInit.addActionListener(this);
        mnuiGamesWishlist.addActionListener(this);
        mnuiDataCollections.addActionListener(this);
        mnuiDataCategory.addActionListener(this);
        mnuiDataLibrary.addActionListener(this);
        mnuiDataPlatforms.addActionListener(this);
        mnuiDataRating.addActionListener(this);
        mnuiHelpConfig.addActionListener(this);
        mnuiPlayerActivities.addActionListener(this);
        mnuiPlayerNotes.addActionListener(this);
        mnuiPlayerViewStatistics.addActionListener(this);
        mnuiPlayerStatisticsPlayCount.addActionListener(this);
        mnuiPlayerStatisticsTotalHours.addActionListener(this);
        mnuiPlayerAddSession.addActionListener(this);
        mnuiPlayerAddAchiev.addActionListener(this);
        mnuiPlayerHistory.addActionListener(this);
        mnuiHelpAbout.addActionListener(this);
        mnuiHelpUpdate.addActionListener(this);
        mnuiHelpDebug.addActionListener(this);
        mnuiItemsCronometer.addActionListener(this);

        mnuiGamesAdd.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        mnuiGamesEdit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        mnuiGamesList.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
        mnuiPlayerAddSession.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        mnuiPlayerHistory.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
        mnuiPlayerActivities.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J, ActionEvent.CTRL_MASK));
        mnuiItemsCronometer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));

        setJMenuBar(menubar);
    }
}
