package com.masciar.dao;

import com.masciar.logging.ErrorHandler;
import com.masciar.model.Achievement;
import com.masciar.util.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AchievementDAO {
    public List<Achievement> getAll() {
        List<Achievement> achievementsList = new ArrayList<>();
        String query = "SELECT * FROM achievements ORDER BY id";

        try (Connection con = DriverManager.getConnection(Utils.DATABASE_URL);
                PreparedStatement ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Achievement a = new Achievement(rs.getInt("id"), rs.getString("game_name"), rs.getInt("game_id"),
                        rs.getString("description"), rs.getString("date"));
                achievementsList.add(a);
            }
        } catch (SQLException e) {
            ErrorHandler.handle(e);
        }
        return achievementsList;
    }

    public void add(Achievement achievements) {
        String query = "INSERT INTO achievements (game_name, game_id, description, date) VALUES (?, ?, ?, ?)";
        try (Connection con = DriverManager.getConnection(Utils.DATABASE_URL);
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, achievements.getGameName());
            ps.setInt(2, achievements.getGameId());
            ps.setString(3, achievements.getDescription());
            ps.setString(4, achievements.getDate());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected != 0)
                System.out.println("Logro añadido");
            else
                System.out.println("Error al añadir logro");
        } catch (SQLException e) {
            //ErrorHandler.handle(e);
        }
    }
}
