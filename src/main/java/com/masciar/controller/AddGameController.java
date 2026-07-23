package com.masciar.controller;

import com.masciar.app.Main;
import com.masciar.model.Categories;
import com.masciar.model.Libraries;
import com.masciar.model.Platforms;
import com.masciar.service.AchievementService;
import com.masciar.service.GameService;
import com.masciar.service.LibraryService;
import com.masciar.ui.AddGameDialog;
import com.masciar.ui.MainWindow;
import com.masciar.util.Utils;

public class AddGameController {
    private AddGameDialog view;
    private GameService GameService;
    private AchievementService achievementService;
    
    public AddGameController(MainWindow window) {
        view = new AddGameDialog(window, true);
        achievementService = new AchievementService(new LibraryService());
        GameService = new GameService(view, achievementService);
        

        loadCategories();
        loadLibraries();
        loadPlatforms();

        view.pack();

        view.showPopupCompletedDateListener(e -> showPopupCompletedDate());
        view.showPopupReleaseDateListener(e -> showPopupReleaseDate());
        view.setBtnSaveListener(e -> {
            boolean saved = GameService.saveData();
            if(saved) view.showInfo("El juego ha sido añadido a tu biblioteca");
            else view.showError("Ha habido un error al agregar el juego a la biblioteca");
        }
            
        );
        view.setSpinGameTimeListener(e -> setSpinGameTimer());

        view.setVisible(true);
    }

    public void loadCategories() {
        for(Categories category : Main.categoryRepository.categories_list) {
            view.fillComboBoxCategory(category.getName());
        }
    }

    public void loadLibraries() {
        for(Libraries library : Main.librariesRepository.library_list) {
            view.fillComboBoxLibrary(library.getName());
        }
    }

    public void loadPlatforms() {
        for(Platforms platforms : Main.platformsRepository.platforms_list) {
            view.filLComboBoxPlatform(platforms.getName());
        }
    }

    public void showPopupCompletedDate() {
        view.showPopupCompletedDate();
    }

    public void showPopupReleaseDate() {
        view.showPopupReleaseDate();
    }

    public void setSpinGameTimer() {
        String string = "(" + Utils.getTotalHoursFromSeconds(view.getSpinGameTimeValue(), true) + ")";
        view.setLblConvertedSeconds(string);
    }
}
