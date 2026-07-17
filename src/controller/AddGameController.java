package controller;

import app.Main;
import dao.GamesDAO;
import model.Categories;
import model.Games;
import model.Libraries;
import model.Platforms;
import service.CategoryService;
import service.LibraryService;
import service.PlatformService;
import ui.AddGame;
import ui.Window;
import util.Utils;
import util.Validations;

public class AddGameController {
    private AddGame view;
    public AddGameController(Window window) {
        view = new AddGame(window, this, true);  

        loadCategories();
        loadLibraries();
        loadPlatforms();
        loadRating();
        
        view.pack();

        view.showPopupCompletedDateListener(e -> showPopupCompletedDate());
        view.showPopupReleaseDateListener(e -> showPopupReleaseDate());
        view.setBtnSaveListener(e -> saveData());
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
        String string = "(" + Utils.getTotalHoursFromSeconds(Integer.parseInt(view.getSpinGameTimeValue()), true) + ")";
        view.setLblConvertedSeconds(string);
        
    }

    public void loadRating() {
        view.cbRating.addItem("E - Everyone");
        view.cbRating.addItem("E10+ - Everyone 10+");
        view.cbRating.addItem("T - Teen");
        view.cbRating.addItem("M - Mature 17+");
        view.cbRating.addItem("A - Adults Only 18+");
        view.cbRating.addItem("EC - Early Childhood");
        view.cbRating.addItem("RP - Rating Pending");
    }

    public boolean saveData() {
        if(Validations.isEmpty(view.txtReleaseDate)) view.txtReleaseDate.setText("1900-01-01");
        if(Validations.isEmpty(view.txtGenre)) view.txtGenre.setText("N/A");
        if(Validations.isEmpty(view.txtDeveloper)) view.txtDeveloper.setText("N/A");
        if(Validations.isEmpty(view.txtPublisher)) view.txtPublisher.setText("N/A");
        if(Validations.isEmpty(view.txtSeries)) view.txtSeries.setText("N/A");
        if(Validations.isEmpty(view.txtStatus)) view.txtStatus.setText("N/A");
        if(Validations.isEmpty(view.txtPlayMode)) view.txtPlayMode.setText("N/A");
        if(Validations.isEmpty(view.txtVersion)) view.txtVersion.setText("N/A");
        if(Validations.isEmpty(view.txtRegion)) view.txtRegion.setText("N/A");
        if(Validations.isEmpty(view.txtPath)) view.txtPath.setText("N/A");
        if(Validations.isEmpty(view.txtCompletedDate)) view.txtCompletedDate.setText("1900-01-01");
        if(Validations.isEmpty(view.txtLastPlayed)) view.txtLastPlayed.setText("1900-01-01");
        if(Validations.isEmpty(view.txtaNotes)) view.txtaNotes.setText(" ");

        int hide = 0, favorite = 0, statistic = 0, portable = 0, completed = 0;
        

        if(view.chFavorite.isSelected()) favorite = 1;
        if(view.chCompleted.isSelected()) completed = 1;
        if(view.chStatistic.isSelected()) statistic = 1;
        if(view.chPortable.isSelected()) portable = 1;
        if(view.chHide.isSelected()) hide = 1;

        PlatformService ps = new PlatformService();
        LibraryService ls = new LibraryService();
        CategoryService cs = new CategoryService();

        String releasedate = view.txtReleaseDate.getText();
        String rating = view.cbRating.getSelectedItem().toString();
        int platform = ps.findIdByName(view.cbPlatform.getSelectedItem().toString());
        String developer = view.txtDeveloper.getText();
        String publisher = view.txtPublisher.getText();
        String series = view.txtSeries.getText();
        String region = view.txtRegion.getText();
        String playMode = view.txtPlayMode.getText();
        String version = view.txtVersion.getText();
        String status = view.txtStatus.getText();
        int library = ls.findIdByName(view.cbLibrary.getSelectedItem().toString());
        String lastPlayed = view.txtLastPlayed.getText();
        String path = view.txtPath.getText();
        String name = view.txtGameName.getText();
        String added = Utils.getFormattedDate();
        String modified = Utils.getFormattedDateTime();
        String completed_date = view.txtCompletedDate.getText();
        String notes = view.txtaNotes.getText();
        int score = (Integer) view.spinScore.getValue();
        int gameTime = (Integer) view.spinGameTime.getValue();
        int category = cs.findIdByName(view.cbCategory.getSelectedItem().toString());
        String image = "";
        int play_count = 0;

        name = name.replace("'", "");
        name = name.replace("\"", "");

        if(Validations.isEmpty(view.txtGameName)) {
            return false;
        } else {
            int id = Main.gameRepository.getList().size() + 1;
            Games game = new Games(id, name, category, library, score, gameTime, play_count, completed, completed_date, hide, path, releasedate,
				developer, series, playMode, status, lastPlayed, rating, platform, publisher, region, version, added, modified, favorite, statistic, 
                portable, image, notes);
            GamesDAO gamesDao = new GamesDAO();
            gamesDao.add(game);
            Main.gameRepository.games_list.add(game);
            view.dispose();
        }
        return true;
    }
}
