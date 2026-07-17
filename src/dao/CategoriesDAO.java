package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Categories;

public class CategoriesDAO {
    private final String url = "jdbc:sqlite:database.db";
    
    public List<Categories> getAll() {
        List<Categories> categories = new ArrayList<>();
        String query = "SELECT * FROM category ORDER BY id";

        try(Connection con = DriverManager.getConnection(url);
	        PreparedStatement ps = con.prepareStatement(query);
	        ResultSet rs = ps.executeQuery()) {

            while(rs.next()) {
                Categories category = new Categories(rs.getInt("id"), rs.getString("name"), rs.getInt("time_played"), rs.getInt("total_sessions"));
                categories.add(category);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    public void add() {

    }

    public void update() {

    }

    public void delete() {

    }
}
