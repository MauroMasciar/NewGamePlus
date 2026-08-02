package com.masciar.service.steam;

import com.masciar.logging.ErrorHandler;
import com.masciar.util.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateGamesListSteam {
    public void update() {
        SteamService ss = new SteamService();
        for (int i = 0; i < ss.getOwnedGames().size(); i++) {
            String query = "INSERT INTO steam_games (name, img_icon_url, app_id, playtime_windows_forever, playtime_linux_forever, playtime_deck_forever, rtime_last_played, content_descriptorids, playtime_disconnected) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) ON CONFLICT (app_id) DO NOTHING";
            try (Connection con = DriverManager.getConnection(Utils.DATABASE_URL);
                    PreparedStatement ps = con.prepareStatement(query)) {
                ps.setString(1, ss.getOwnedGames().get(i).getName());
                ps.setString(2, ss.getOwnedGames().get(i).getImg_icon_url());
                ps.setInt(3, ss.getOwnedGames().get(i).getAppid());
                ps.setInt(4, ss.getOwnedGames().get(i).getPlaytime_windows_forever());
                ps.setInt(5, ss.getOwnedGames().get(i).getPlaytime_linux_forever());
                ps.setInt(6, ss.getOwnedGames().get(i).getPlaytime_deck_forever());
                ps.setLong(7, ss.getOwnedGames().get(i).getRtime_last_played());
                ps.setInt(8, 0);
                ps.setInt(9, ss.getOwnedGames().get(i).getPlaytime_disconnected());

                int rowsAffected = ps.executeUpdate();
                if (rowsAffected != 0)
                    System.out.println(i + " agregado");
            } catch (SQLException e) {
                ErrorHandler.handle(e);
            }
        }
    }
}
