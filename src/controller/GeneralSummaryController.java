package controller;

import ui.GeneralSummary;
import ui.Window;
import util.Utils;
import service.PlayerService;

public class GeneralSummaryController {
    Window window;
    GeneralSummary view;
    PlayerService playerService;

    public GeneralSummaryController(Window window) {
        this.window = window;
        view = new GeneralSummary();
        playerService = new PlayerService();
        window.add(view);

        loadData();
    }

    private void loadData() {
        view.setLblTotalTimeHoursValue(Utils.getTotalHoursFromSeconds(playerService.getTotalTimePlayed(), false));
        view.setlblTotalTimeDaysValue(Utils.getTotalDaysFromSeconds(playerService.getTotalTimePlayed()));
        view.lblTotalGamesStartedValue("0");
        view.lblCompletedValue("0");
        view.lblSessionsValue(String.valueOf(playerService.getTotalSessions()));
    }    
}
