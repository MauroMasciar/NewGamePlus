package app;

import repository.GameRepository;
import ui.Window;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;

public class Main {
    public static final String VERSION_APP = "2.0.0.4";
    public static GameRepository repository;

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatMacDarkLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        // Se inician los repositorios
        repository = new GameRepository();

        // Se inicia la ventana principal
        Window mw = new Window();

        // Testing
        //Chronometer c = new Chronometer();
    }
}
