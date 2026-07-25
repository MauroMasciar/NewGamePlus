package com.masciar.controller;

import com.masciar.service.ConfigService;
import com.masciar.ui.Config;

import javax.swing.JDesktopPane;

public class ConfigController {
    Config view = new Config();
    public ConfigController(JDesktopPane desktopPane) {
        desktopPane.add(view);

        view.setBtnSaveListener(e -> saveConfig());

    }

    public void saveConfig() {
        ConfigService.setProperty("steam.id", view.getTxtSteamId());
    }
}
