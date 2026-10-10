package com.masciar.dao;

import com.masciar.logging.ErrorHandler;
import com.masciar.model.Achievement;
import com.masciar.model.Game;
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

    public int add(Achievement achievement) { // TODO: Mostrar mensaje al usuario si no logra añadir el logro
        String query = "INSERT INTO achievements (game_name, game_id, description, date) VALUES (?, ?, ?, ?)";
        try (Connection con = DriverManager.getConnection(Utils.DATABASE_URL);
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, achievement.getGameName());
            ps.setInt(2, achievement.getGameId());
            ps.setString(3, achievement.getDescription());
            ps.setString(4, achievement.getDate());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected != 0) {
                query = "SELECT id FROM achievements WHERE description = '" + achievement.getDescription() + "'";
                try (Connection conn = DriverManager.getConnection(Utils.DATABASE_URL);
                        PreparedStatement pss = con.prepareStatement(query);
                        ResultSet rs = pss.executeQuery()) {
                            conn.close();
                    return rs.getInt(1);
                } catch (SQLException e) {
                    ErrorHandler.handle(e);
                }
            }
        } catch (SQLException e) {
            ErrorHandler.handle(e);
        }
        return 0;
    }

    public void changeName(Game game) {
        String query = "UPDATE achievements SET game_name = ? WHERE game_id = ?";
        try (Connection con = DriverManager.getConnection(Utils.DATABASE_URL);
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, game.getName());
            ps.setInt(2, game.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            ErrorHandler.handle(e);
        }
    }
}
