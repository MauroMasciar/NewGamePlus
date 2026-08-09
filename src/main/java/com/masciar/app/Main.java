/**
 * NewGame+
 *
 * NewGame+ es una aplicación diseñada para administrar una biblioteca personal de videojuegos,
 * permitiendo organizar la colección, registrar sesiones de juego, consultar estadísticas
 * y mantener un historial de actividad.
 * 
 *
 * Repositorio:
 * https://github.com/MauroMasciar/NewGamePlus
 * 
 *
 * Historial de versiones:
 * - v1.0 - Iniciada el 23 de octubre de 2023
 * - v2.0 - Iniciada el 13 de julio de 2026
 * 
 *
 * @author Mauro Masciadro
 * @version 2.0
 */

package com.masciar.app;

import com.masciar.logging.ErrorHandler;
import com.masciar.repository.AchievementRepository;
import com.masciar.repository.CategoryRepository;
import com.masciar.repository.GameRepository;
import com.masciar.repository.HistoryRepository;
import com.masciar.repository.LibraryRepository;
import com.masciar.repository.PlatformsRepository;
import com.masciar.repository.PlayerRepository;
import com.masciar.repository.SteamGamesRepository;
import com.masciar.service.ScreenshotService;
import com.masciar.ui.MainWindow;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;

public class Main {
    public static final String VERSION_APP = "2.0.45";
    public static PlayerRepository playerRepository;
    public static GameRepository gameRepository;
    public static CategoryRepository categoryRepository;
    public static LibraryRepository librariesRepository;
    public static PlatformsRepository platformsRepository;
    public static AchievementRepository achievementsRepository;
    public static HistoryRepository historyRepository;
    public static SteamGamesRepository steamGamesRepository;

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatMacDarkLaf());
        } catch (UnsupportedLookAndFeelException e) {
            ErrorHandler.handle(e);
        }

        playerRepository = new PlayerRepository();
        gameRepository = new GameRepository();
        categoryRepository = new CategoryRepository();
        librariesRepository = new LibraryRepository();
        platformsRepository = new PlatformsRepository();
        achievementsRepository = new AchievementRepository();
        historyRepository = new HistoryRepository();
        steamGamesRepository = new SteamGamesRepository();

        new ScreenshotService();

        // Se inicia la ventana principal
        MainWindow mw = new MainWindow();

        // UpdateGamesListSteam u = new UpdateGamesListSteam();
        // u.update();
        // ss.getAchievementsGame(377160);
    }
}
