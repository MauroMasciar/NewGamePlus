package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Game;

public class GameDAO {
	private final String url = "jdbc:sqlite:database.db";

	public List<Game> getAll() {
	    List<Game> games = new ArrayList<>();

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

	public void add() {
		
	}

	public void update(Game game) {
		String query = "UPDATE games SET name = ?, category = ?, library = ?, score = ?, time_played = ?, play_count = ?, completed = ?, completed_date = ?, hidden = ?, path = ?, release_date = ?, developer = ?, series = ?, play_mode = ?, status = ?, source = ?, last_played = ?, rating = ?, platform = ?, publisher = ?, region = ?, version = ?, added = ?, modified = ?, favorite = ?, statistic = ?, portable = ?, image = ?, notes = ? WHERE id = ?;";
		try (Connection con = DriverManager.getConnection(url);
			 PreparedStatement ps = con.prepareStatement(query)) {

			ps.setString(1, game.getName());
			ps.setInt(2, game.getCategory());
			ps.setInt(3, game.getLibrary());
			ps.setInt(4, game.getScore());
			ps.setInt(5, game.getTimePlayed());
			ps.setInt(6, game.getPlayCount());
			ps.setInt(7, game.getCompleted());
			ps.setString(8, game.getCompletedDate());
			ps.setInt(9, game.getHidden());
			ps.setString(10, game.getPath());
			ps.setString(11, game.getReleaseDate());
			ps.setString(12, game.getDeveloper());
			ps.setString(13, game.getSeries());
			ps.setString(14, game.getPlayMode());
			ps.setString(15, game.getStatus());
			ps.setString(16, game.getSource());
			ps.setString(17, game.getLastPlayed());
			ps.setInt(18, game.getRating());
			ps.setInt(19, game.getPlatform());
			ps.setString(20, game.getPublisher());
			ps.setString(21, game.getRegion());
			ps.setString(22, game.getVersion());
			ps.setString(23, game.getAdded());
			ps.setString(24, game.getModified());
			ps.setInt(25, game.getFavorite());
			ps.setInt(26, game.getStatistic());
			ps.setInt(27, game.getPortable());
			ps.setString(28, game.getImage());
			ps.setString(29, game.getNotes());
			ps.setInt(30, game.getId());

			int rowsAffected = ps.executeUpdate();
			if(rowsAffected != 0) System.out.println("Juego actualizado");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete() {

	}
}
