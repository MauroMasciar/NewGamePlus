package ui;

import app.Main;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class Window extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1092418710020581973L;
	private final JMenuBar menubar = new JMenuBar();
    private final JMenu mnuGames = new JMenu("Juegos");
    private final JMenuItem mnuiGamesAdd = new JMenuItem("Nuevo", new ImageIcon("gfx/new_game.png"));
    private final JMenuItem mnuiGamesEdit = new JMenuItem("Editar");
    public JMenuItem mnuiGamesList = new JMenuItem("Ver biblioteca", new ImageIcon("gfx/games_list.png"));
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
    private final JMenuItem mnuiPlayerAddSession = new JMenuItem("Añadir sesión", new ImageIcon("gfx/new_session.png"));
    private final JMenuItem mnuiPlayerAddAchiev = new JMenuItem("Añadir hazaña", new ImageIcon("gfx/x.png"));
    private final JMenuItem mnuiPlayerActivities = new JMenuItem("Actividad", new ImageIcon("gfx/history.png"));
    private final JMenuItem mnuiPlayerNotes = new JMenuItem("Notas", new ImageIcon("gfx/notes.png"));
    private final JMenuItem mnuiPlayerHistory = new JMenuItem("Historial", new ImageIcon("gfx/activity.png"));
    private final JMenu mnuData = new JMenu("Datos");
    private final JMenuItem mnuiDataCategory = new JMenuItem("Categorías", new ImageIcon("gfx/category.png"));
    private final JMenuItem mnuiDataCollections = new JMenuItem("Colecciones", new ImageIcon("gfx/collections.png"));
    private final JMenuItem mnuiDataLibrary = new JMenuItem("Bibliotecas", new ImageIcon("gfx/library.png"));
    private final JMenuItem mnuiDataPlatforms = new JMenuItem("Plataformas", new ImageIcon("gfx/library.png"));
    private final JMenuItem mnuiDataRefresh = new JMenuItem("Actualizar", new ImageIcon("gfx/refresh.png"));
    private final JMenuItem mnuiDataRating = new JMenuItem("Rating");
    private final JMenu mnuUtils = new JMenu("Utilidades");
    private final JMenuItem mnuiItemsCronometer = new JMenuItem("Cronometro");
    private final JMenuItem mnuiItemsTimer = new JMenuItem("Temporizador");
    private final JMenu mnuHelp = new JMenu("Ayuda");
    private final JMenuItem mnuiHelpConfig = new JMenuItem("Configuración", new ImageIcon("gfx/config.png"));
    private final JMenuItem mnuiHelpUpdate = new JMenuItem("Actualizar", new ImageIcon("gfx/update.png"));
    private final JMenuItem mnuiHelpAbout = new JMenuItem("Acerca de", new ImageIcon("gfx/about.png"));
    private final JMenuItem mnuiHelpDebug = new JMenuItem("Debug", new ImageIcon("gfx/debug.png"));
    private final JMenuItem mnuiGamesExit = new JMenuItem("Salir");
	public Window() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		String title = "DYWTPN v" + Main.VERSION_APP;
		setTitle(title);
        setIconImage(new ImageIcon(getClass().getResource("/resources/icons/icon.png")).getImage());
        setBounds(30, 30, 1400, 900);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
		setLayout(new FlowLayout());

		createMenuBar();

		add(new GamesList());
		

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

	public void createMenuBar() {
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
