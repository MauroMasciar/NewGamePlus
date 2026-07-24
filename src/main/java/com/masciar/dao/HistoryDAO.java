package com.masciar.dao;

import com.masciar.model.History;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HistoryDAO {
	private final String url = "jdbc:sqlite:database.db";

	public List<History> getAll() {
		List<History> history = new ArrayList<>();

		String query = "SELECT * FROM games_sessions_history ORDER BY id";

		try (Connection con = DriverManager.getConnection(url);
				PreparedStatement ps = con.prepareStatement(query);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				History h = new History(rs.getInt("id"), rs.getString("token"), rs.getInt("game_id"),
						rs.getString("game_name"), rs.getInt("library_id"), rs.getInt("platform_id"),
						rs.getString("datetime_start"), rs.getString("datetime_end"), rs.getInt("seconds"));
				history.add(h);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return history;
	}

	public void add(History history) {
		String query = "INSERT INTO games_sessions_history (token, game_id, game_name, library_id, platform_id, datetime_start, datetime_end, seconds) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try (Connection con = DriverManager.getConnection(url);
				PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, history.getToken());
			ps.setInt(2, history.getGameId());
			ps.setString(3, history.getGameName());
			ps.setInt(4, history.getLibraryId());
			ps.setInt(5, history.getPlatformId());
			ps.setString(6, history.getDateTimeStart());
			ps.setString(7, history.getDateTimeEnd());
			ps.setInt(8, history.getSeconds());

			int rowsAffected = ps.executeUpdate();
			if (rowsAffected != 0)
				System.out.println("Juego añadido al historial");
			else
				System.out.println("Error al añadir sesion al historial");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String getLastSessionFromGame(int id) {
		String query = "SELECT datetime_start FROM games_sessions_history WHERE game_id = " + id
				+ " ORDER BY id DESC LIMIT 1";
		try (Connection con = DriverManager.getConnection(url);
				PreparedStatement ps = con.prepareStatement(query)) {
			ResultSet rs = ps.executeQuery();
			return rs.getString("datetime_start");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int getLastSessionTimeFromGame(int id) {
		String query = "SELECT seconds FROM games_sessions_history WHERE game_id = " + id + " ORDER BY id DESC LIMIT 1";
		try (Connection con = DriverManager.getConnection(url);
				PreparedStatement ps = con.prepareStatement(query)) {
			ResultSet rs = ps.executeQuery();
			return rs.getInt("seconds");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
