package app;

import repository.GameRepository;
import ui.Window;

public class Main {
    public static GameRepository repository;

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        repository = new GameRepository();
        Window mw = new Window();
    }
}
