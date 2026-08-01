package com.masciar.dao;

import com.masciar.app.Main;
import com.masciar.logging.ErrorHandler;
import com.masciar.model.Platforms;
import com.masciar.util.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlatformDAO {
    public List<Platforms> getAll() {
        List<Platforms> Platforms = new ArrayList<>();
        String query = "SELECT * FROM platforms ORDER BY id";

        try (Connection con = DriverManager.getConnection(Utils.DATABASE_URL);
                PreparedStatement ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Platforms platforms = new Platforms(rs.getInt("id"), rs.getString("name"), rs.getInt("time_played"),
                        rs.getInt("total_sessions"));
                Platforms.add(platforms);
            }
        } catch (SQLException e) {
            ErrorHandler.handle(e);
        }
        return Platforms;
    }

    public void update(int i) {
        String query = "UPDATE platforms SET time_played = ?, total_sessions = ? WHERE id = ?";
        try (Connection con = DriverManager.getConnection(Utils.DATABASE_URL);
                PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, Main.platformsRepository.platforms_list.get(i).getTimePlayed());
            ps.setInt(2, Main.platformsRepository.platforms_list.get(i).getTotalSessions());
            ps.setInt(3, i);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected != 0)
                System.out.println("Plataforma actualizada");
        } catch (SQLException e) {
            ErrorHandler.handle(e);
        }
    }
}
