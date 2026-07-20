/**
 * NewGame+
 *
 * Gestor de videojuegos de código abierto con estadísticas, historial de sesiones,
 * resúmenes y sincronización con el perfil en la web.
 *
 * Repositorio:
 * https://github.com/MauroMasciar/NewGamePlus
 *
 * Historial de versiones:
 * - v1.0 - Iniciada el 23 de octubre de 2023
 * - v2.0 - Iniciada el 13 de julio de 2026
 *
 * @author Mauro Masciadro
 * @version 2.0
 */

package app;

import repository.AchievementRepository;
import repository.CategoryRepository;
import repository.GameRepository;
import repository.HistoryRepository;
import repository.LibraryRepository;
import repository.PlatformsRepository;
import repository.PlayerRepository;
import ui.Window;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;

public class Main {
    public static final String VERSION_APP = "2.0.0.16";
    public static PlayerRepository playerRepository;
    public static GameRepository gameRepository;
    public static CategoryRepository categoryRepository;
    public static LibraryRepository librariesRepository;
    public static PlatformsRepository platformsRepository;
    public static AchievementRepository achievementsRepository;
    public static HistoryRepository historyRepository;
    
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatMacDarkLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        // Se inician los repositorios
        playerRepository = new PlayerRepository();
        gameRepository = new GameRepository();
        categoryRepository = new CategoryRepository();
        librariesRepository = new LibraryRepository();
        platformsRepository = new PlatformsRepository();
        achievementsRepository = new AchievementRepository();
        historyRepository = new HistoryRepository();

        // Se inicia la ventana principal
        Window mw = new Window();

        // test
        //test t = new test();
    }
}
