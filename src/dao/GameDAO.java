package dao;

import model.Game;

import java.util.ArrayList;
import java.util.List;

public class GameDAO {
	public List<Game> getAllGames() {

	    List<Game> games = new ArrayList<>();

	    /*String sql = "SELECT * FROM games ORDER BY name";

	    try(Connection con = Database.getConnection();
	        PreparedStatement ps = con.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery()) {

	        while(rs.next()) {

	            Game game = new Game();

	            game.setId(rs.getInt("id"));
	            game.setName(rs.getString("name"));
	            game.setTimePlayed(rs.getInt("seconds_played"));
	            game.setPlatform(rs.getInt("platform"));

	            games.add(game);
	        }

	    } catch(SQLException e) {
	        e.printStackTrace();
	    }*/

	    return games;
	}
}
