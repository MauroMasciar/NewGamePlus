package com.masciar.dao;

import com.masciar.app.Main;
import com.masciar.logging.ErrorHandler;
import com.masciar.model.Categories;
import com.masciar.util.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {
    public List<Categories> getAll() {
        List<Categories> categories = new ArrayList<>();
        String query = "SELECT * FROM category ORDER BY id";

        try (Connection con = DriverManager.getConnection(Utils.DATABASE_URL);
                PreparedStatement ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Categories category = new Categories(rs.getInt("id"), rs.getString("name"), rs.getInt("time_played"),
                        rs.getInt("total_sessions"));
                categories.add(category);
            }
        } catch (SQLException e) {
            ErrorHandler.handle(e);
        }
        return categories;
    }

    public void update(int i) {
        String query = "UPDATE category SET time_played = ?, total_sessions = ? WHERE id = ?";
        try (Connection con = DriverManager.getConnection(Utils.DATABASE_URL);
                PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, Main.categoryRepository.categories_list.get(i).getTimePlayed());
            ps.setInt(2, Main.categoryRepository.categories_list.get(i).getTotalSessions());
            ps.setInt(3, i);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected != 0)
                System.out.println("Categoria actualizada");
        } catch (SQLException e) {
            ErrorHandler.handle(e);
        }
    }
}
