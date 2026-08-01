package com.masciar.dao;

import com.masciar.logging.ErrorHandler;
import com.masciar.model.Player;
import com.masciar.util.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlayerDAO {
    public List<Player> getAll() {
        List<Player> player_list = new ArrayList<>();
        String query = "SELECT * FROM view_generalsummary";

        try (Connection con = DriverManager.getConnection(Utils.DATABASE_URL);
                PreparedStatement ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Player player = new Player(rs.getInt("id"), rs.getString("game_name"),
                        rs.getInt("last_game_session_time"), rs.getInt("total_time"), rs.getInt("total_sessions"),
                        rs.getInt("total_started"), rs.getInt("completed"));
                player_list.add(player);
            }
        } catch (SQLException e) {
            ErrorHandler.handle(e);
        }
        return player_list;
    }
}
