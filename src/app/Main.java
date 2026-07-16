package app;

import repository.CategoryRepository;
import repository.GameRepository;
import repository.LibrariesRepository;
import repository.PlatformsRepository;
import ui.Window;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;

public class Main {
    public static final String VERSION_APP = "2.0.0.6";
    public static GameRepository gameRepository;
    public static CategoryRepository categoryRepository;
    public static LibrariesRepository librariesRepository;
    public static PlatformsRepository platformsRepository;
    
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatMacDarkLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        // Se inician los repositorios
        gameRepository = new GameRepository();
        categoryRepository = new CategoryRepository();
        librariesRepository = new LibrariesRepository();
        platformsRepository = new PlatformsRepository();

        // Se inicia la ventana principal
        Window mw = new Window();

        // test
        //test t = new test();
    }
}
