package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Platforms;

public class PlatformsDAO {
    private final String url = "jdbc:sqlite:database.db";
    
    public List<Platforms> getAll() {
        List<Platforms> Platforms = new ArrayList<>();
        String query = "SELECT * FROM platforms ORDER BY id";

        try(Connection con = DriverManager.getConnection(url);
	        PreparedStatement ps = con.prepareStatement(query);
	        ResultSet rs = ps.executeQuery()) {

            while(rs.next()) {
                Platforms platforms = new Platforms(rs.getInt("id"), rs.getString("name"), rs.getInt("time_played"), rs.getInt("total_sessions"));
                Platforms.add(platforms);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return Platforms;
    }

    public void add() {

    }

    public void update() {

    }

    public void delete() {

    }
}
