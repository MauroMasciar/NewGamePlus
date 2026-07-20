package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import app.Main;
import model.Player;

public class PlayerDAO {
private final String url = "jdbc:sqlite:database.db";
    
    public List<Player> getAll() {
        List<Player> player_list = new ArrayList<>();
        String query = "SELECT * FROM players ORDER BY id";

        try(Connection con = DriverManager.getConnection(url);
	        PreparedStatement ps = con.prepareStatement(query);
	        ResultSet rs = ps.executeQuery()) {

            while(rs.next()) {
                Player player = new Player(rs.getInt("id"), rs.getString("name"), rs.getString("last_game"), rs.getString("last_session_time"), rs.getInt("total_sessions"), rs.getInt("played_time"));
                player_list.add(player);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return player_list;
    }

    public void update() {
        String query = "UPDATE players SET played_time = ?, total_sessions = ? WHERE id = ?";
		try (Connection con = DriverManager.getConnection(url);
			 PreparedStatement ps = con.prepareStatement(query)) {

                ps.setInt(1, Main.playerRepository.players_list.get(0).getTimePlayed());
                ps.setInt(2, Main.playerRepository.players_list.get(0).getTotalSessions());
                ps.setInt(3, 1);
			    int rowsAffected = ps.executeUpdate();
			    if(rowsAffected != 0) System.out.println("Jugador actualizado");
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
}
