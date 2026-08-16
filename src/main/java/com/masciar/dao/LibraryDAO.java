package com.masciar.dao;

import com.masciar.app.Main;
import com.masciar.logging.ErrorHandler;
import com.masciar.model.Library;
import com.masciar.util.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LibraryDAO {
    public List<Library> getAll() {
        List<Library> libraries = new ArrayList<>();
        String query = "SELECT * FROM library ORDER BY id";

        try (Connection con = DriverManager.getConnection(Utils.DATABASE_URL);
                PreparedStatement ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Library library = new Library(rs.getInt("id"), rs.getString("name"), rs.getInt("time_played"),
                        rs.getInt("total_sessions"));
                libraries.add(library);
            }
        } catch (SQLException e) {
            ErrorHandler.handle(e);
        }
        return libraries;
    }

    public void update(int i) {
        String query = "UPDATE library SET time_played = ?, total_sessions = ? WHERE id = ?";
        try (Connection con = DriverManager.getConnection(Utils.DATABASE_URL);
                PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, Main.librariesRepository.library_list.get(i).getTimePlayed());
            ps.setInt(2, Main.librariesRepository.library_list.get(i).getTotalSession());
            ps.setInt(3, i);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected != 0)
                System.out.println("Libreria actualizada");
        } catch (SQLException e) {
            ErrorHandler.handle(e);
        }
    }
}
