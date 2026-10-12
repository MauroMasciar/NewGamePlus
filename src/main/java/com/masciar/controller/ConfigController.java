package com.masciar.controller;

import com.masciar.service.ConfigService;
import com.masciar.service.Toast;
import com.masciar.ui.Config;

import javax.swing.JDesktopPane;

public class ConfigController {
    Config view = new Config();
    public ConfigController(JDesktopPane desktopPane) {
        desktopPane.add(view);
        view.toFront();

        view.setTxtSteamId(ConfigService.getProperty("steam.id"));
        view.setBtnSaveListener(e -> saveConfig());
        view.setBtnUpdateDataCategories(e -> updateDataCategories());
        view.setBtnUpdateSteamAchievements(e -> updateSteamAchievements());
    }

    public void saveConfig() {
        ConfigService.setProperty("steam.id", view.getTxtSteamId());
        view.dispose();
    }

    public void updateDataCategories() {
        ConfigService configService = new ConfigService();
        configService.updateDataCategories();
    }

    public void updateSteamAchievements() {
        ConfigService configService = new ConfigService();
        configService.updateSteamAchievements();
        Toast.showToast(view, "Lista de logros actualizada");
    }
}
