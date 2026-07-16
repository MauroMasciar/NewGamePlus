package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Libraries;

public class LibrariesDAO {
    private final String url = "jdbc:sqlite:database.db";
    
    public List<Libraries> getAll() {
        List<Libraries> libraries = new ArrayList<>();
        String query = "SELECT * FROM library ORDER BY id";

        try(Connection con = DriverManager.getConnection(url)) {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery(query);

            while(rs.next()) {
                Libraries library = new Libraries(rs.getInt("id"), rs.getString("name"), rs.getInt("time_played"), rs.getInt("total_sessions"));
                libraries.add(library);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return libraries;
    }

    public void add() {

    }

    public void update() {

    }

    public void delete() {

    }
}
