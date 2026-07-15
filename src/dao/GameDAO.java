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
		String query = "SELECT * FROM games ORDER BY id";

	    try(Connection con = DriverManager.getConnection(url);
	        PreparedStatement ps = con.prepareStatement(query);
	        ResultSet rs = ps.executeQuery()) {

	        while(rs.next()) {
	            Game game = new Game(rs.getInt("id"), rs.getString("name"), rs.getInt("category"), rs.getInt("library"), rs.getInt("score"), rs.getInt("time_played"), 
					rs.getInt("play_count"), rs.getInt("completed"), rs.getString("completed_date"), rs.getInt("hidden"), rs.getString("path"), rs.getString("release_date"),
					rs.getString("developer"), rs.getString("series"), rs.getString("play_mode"), rs.getString("status"), rs.getString("source"), rs.getString("last_played"), 
					rs.getInt("rating"), rs.getInt("platform"), rs.getString("publisher"), rs.getString("region"), rs.getString("version"), rs.getString("added"), 
					rs.getString("modified"), rs.getInt("favorite"), rs.getInt("statistic"), rs.getInt("portable"), rs.getString("image"), rs.getString("notes"));
					
				games.add(game);
	        }
	    } catch(SQLException e) {
	        e.printStackTrace();
	    }

	    return games;
	}

	public void addGame() {
		
	}

	public void updateGame() {

	}

	public void deleteGame() {

	}
}
