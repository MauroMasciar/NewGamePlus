package dao;

import model.Player;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlayerDAO {
private final String url = "jdbc:sqlite:database.db";
    
    public List<Player> getAll() {
        List<Player> player_list = new ArrayList<>();
        String query = "SELECT * FROM view_generalsummary";

        try(Connection con = DriverManager.getConnection(url);
	        PreparedStatement ps = con.prepareStatement(query);
	        ResultSet rs = ps.executeQuery()) {

            while(rs.next()) {
                Player player = new Player(rs.getInt("id"), rs.getString("game_name"), rs.getInt("last_game_session_time"), rs.getInt("total_time"), rs.getInt("total_sessions"), rs.getInt("total_started"), rs.getInt("completed"));
                player_list.add(player);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return player_list;
    }
}
