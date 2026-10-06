package com.masciar.dao;

import com.masciar.app.Main;
import com.masciar.logging.ErrorHandler;
import com.masciar.model.Category;
import com.masciar.util.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {
    public List<Category> getAll() {
        List<Category> categories = new ArrayList<>();
        String query = "SELECT * FROM category ORDER BY id";

        try (Connection con = DriverManager.getConnection(Utils.DATABASE_URL);
                PreparedStatement ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Category category = new Category(rs.getInt("id"), rs.getString("name"), rs.getInt("time_played"), rs.getInt("total_sessions"));
                categories.add(category);
            }
        } catch (SQLException e) {
            ErrorHandler.handle(e);
        }
        return categories;
    }

    public void update(int id) {
        String query = "UPDATE category SET time_played = ?, total_sessions = ? WHERE id = ?";
        try (Connection con = DriverManager.getConnection(Utils.DATABASE_URL);
                PreparedStatement ps = con.prepareStatement(query)) {
            for (int i = 0; i < Main.categoryRepository.categories_list.size(); i++) {
                if (Main.categoryRepository.categories_list.get(i).getId() == id) {
                    ps.setInt(1, Main.categoryRepository.categories_list.get(i).getTimePlayed());
                    ps.setInt(2, Main.categoryRepository.categories_list.get(i).getTotalSessions());
                    ps.setInt(3, id);
                    break;
                }
            }

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected != 0)
                System.out.println("Categoria actualizada");
        } catch (SQLException e) {
            ErrorHandler.handle(e);
        }
    }

    public void updateAll() {
        for (int i = 0; i < Main.categoryRepository.categories_list.size(); i++) {
            String query = "SELECT SUM(time_played) AS total FROM games WHERE category = " + Main.categoryRepository.categories_list.get(i).getId();
            try (Connection con = DriverManager.getConnection(Utils.DATABASE_URL);
                    PreparedStatement ps = con.prepareStatement(query);
                    ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int timePlayed = rs.getInt("total");
                    query = "UPDATE category SET time_played = ? WHERE id = ?";
                    PreparedStatement psu = con.prepareStatement(query);
                    psu.setInt(1, timePlayed);
                    psu.setInt(2, Main.categoryRepository.categories_list.get(i).getId());
                    psu.executeUpdate();

                    Main.categoryRepository.categories_list.get(i).setTimePlayed(timePlayed);
                }
            } catch (SQLException e) {
                ErrorHandler.handle(e);
            }

            query = "SELECT SUM(play_count) AS total FROM games WHERE category = " + Main.categoryRepository.categories_list.get(i).getId();
            try (Connection con = DriverManager.getConnection(Utils.DATABASE_URL);
                    PreparedStatement ps = con.prepareStatement(query);
                    ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int totalSessions = rs.getInt("total");
                    query = "UPDATE category SET total_sessions = ? WHERE id = ?";
                    PreparedStatement psu = con.prepareStatement(query);
                    psu.setInt(1, totalSessions);
                    psu.setInt(2, Main.categoryRepository.categories_list.get(i).getId());
                    psu.executeUpdate();

                    Main.categoryRepository.categories_list.get(i).setTotalSessions(totalSessions);
                }
            } catch (SQLException e) {
                ErrorHandler.handle(e);
            }
        }
    }
}
