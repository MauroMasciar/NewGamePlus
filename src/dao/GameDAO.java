package dao;

import model.Game;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GameDAO {
	public List<Game> getAllGames() {
	    List<Game> games = new ArrayList<>();

		String url = "jdbc:sqlite:database.db";		
		String query = "SELECT id, name FROM games ORDER BY id";

	    try(Connection con = DriverManager.getConnection(url);
	        PreparedStatement ps = con.prepareStatement(query);
	        ResultSet rs = ps.executeQuery()) {

	        while(rs.next()) {
	            Game game = new Game(rs.getInt("id"), rs.getString("name"));
				games.add(game);
	        }
	    } catch(SQLException e) {
	        e.printStackTrace();
	    }

	    return games;
	}
}
