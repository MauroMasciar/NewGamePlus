package com.masciar.dao;

import com.masciar.logging.ErrorHandler;
import com.masciar.model.SteamGames;
import com.masciar.util.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SteamDAO {
    public List<SteamGames> getAll() {
        List<SteamGames> gameList = new ArrayList<>();
        String query = "SELECT * FROM steam_games";

        try (Connection con = DriverManager.getConnection(Utils.DATABASE_URL);
                PreparedStatement ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                SteamGames game = new SteamGames(rs.getInt("id"), rs.getString("name"), rs.getString("img_icon_url"), rs.getInt("app_id"), rs.getInt("playtime_windows_forever"),
                      rs.getInt("playtime_linux_forever"), rs.getInt("playtime_deck_forever"), rs.getInt("rtime_last_played"),
                      rs.getInt("content_descriptorids"), rs.getInt("playtime_disconnected"));
                      gameList.add(game);
            }
        } catch (SQLException e) {
            ErrorHandler.handle(e);
        }
        return gameList;
    }
}
