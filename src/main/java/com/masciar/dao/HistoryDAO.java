package com.masciar.dao;

import com.masciar.logging.ErrorHandler;
import com.masciar.model.Game;
import com.masciar.model.History;
import com.masciar.util.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HistoryDAO {
	public List<History> getAll() {
		List<History> history = new ArrayList<>();

		String query = "SELECT * FROM games_sessions_history ORDER BY id";

		try (Connection con = DriverManager.getConnection(Utils.DATABASE_URL);
				PreparedStatement ps = con.prepareStatement(query);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				History h = new History(rs.getInt("id"), rs.getString("token"), rs.getInt("game_id"),
						rs.getString("game_name"), rs.getInt("library_id"), rs.getInt("platform_id"),
						rs.getString("datetime_start"), rs.getString("datetime_end"), rs.getInt("seconds"),
						rs.getString("game_version"));
				history.add(h);
			}
		} catch (SQLException e) {
			ErrorHandler.handle(e);
		}
		return history;
	}

	public void add(History history) {
		String query = "INSERT INTO games_sessions_history (token, game_id, game_name, library_id, platform_id, datetime_start, datetime_end, seconds, game_version) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try (Connection con = DriverManager.getConnection(Utils.DATABASE_URL);
				PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, history.getToken());
			ps.setInt(2, history.getGameId());
			ps.setString(3, history.getGameName());
			ps.setInt(4, history.getLibraryId());
			ps.setInt(5, history.getPlatformId());
			ps.setString(6, history.getDateTimeStart());
			ps.setString(7, history.getDateTimeEnd());
			ps.setInt(8, history.getSeconds());
			ps.setString(9, history.getGameVersion());

			int rowsAffected = ps.executeUpdate();
			if (rowsAffected != 0)
				System.out.println("Juego añadido al historial");
			else
				System.out.println("Error al añadir sesion al historial");
		} catch (SQLException e) {
			ErrorHandler.handle(e);
		}
	}

	public void changeName(Game game) {
		String query = "UPDATE games_sessions_history SET game_name = ? WHERE game_id = ?";
		try (Connection con = DriverManager.getConnection(Utils.DATABASE_URL);
				PreparedStatement ps = con.prepareStatement(query)) {
					ps.setString(1, game.getName());
					ps.setInt(2, game.getId());
					ps.executeUpdate();
		} catch (SQLException e) {
			ErrorHandler.handle(e);
		}
	}

	public String getLastSessionFromGame(int gameId) {
		String query = "SELECT datetime_start FROM games_sessions_history WHERE game_id = " + gameId
				+ " ORDER BY id DESC LIMIT 1";
		try (Connection con = DriverManager.getConnection(Utils.DATABASE_URL);
				PreparedStatement ps = con.prepareStatement(query)) {
			ResultSet rs = ps.executeQuery();
			return rs.getString("datetime_start");
		} catch (SQLException e) {
			ErrorHandler.handle(e);
		}
		return null;
	}

	public int getLastSessionTimeFromGame(int gameId) {
		String query = "SELECT seconds FROM games_sessions_history WHERE game_id = " + gameId
				+ " ORDER BY id DESC LIMIT 1";
		try (Connection con = DriverManager.getConnection(Utils.DATABASE_URL);
				PreparedStatement ps = con.prepareStatement(query)) {
			ResultSet rs = ps.executeQuery();
			return rs.getInt("seconds");
		} catch (SQLException e) {
			ErrorHandler.handle(e);
		}
		return 0;
	}

	public int getCountSessionsLastMonth(int gameId) {
		String query = "SELECT count(id) AS id FROM games_sessions_history WHERE game_id = " + gameId
				+ " AND `datetime_start` BETWEEN datetime('now', '-30 day') AND datetime('now');";
		try (Connection con = DriverManager.getConnection(Utils.DATABASE_URL);
				PreparedStatement ps = con.prepareStatement(query)) {
			ResultSet rs = ps.executeQuery();
			return rs.getInt("id");
		} catch (SQLException e) {
			ErrorHandler.handle(e);
		}
		return 0;
	}

	public int getLastDays(int gameId, int days) {
		String query;
		if (gameId == 0) {
			if (days == 1)
				query = "SELECT SUM(seconds) AS seconds FROM games_sessions_history WHERE `datetime_start` BETWEEN datetime('now', '-1 day') AND datetime('now');";
			else if (days == 7)
				query = "SELECT SUM(seconds) AS seconds FROM games_sessions_history WHERE `datetime_start` BETWEEN datetime('now', '-7 day') AND datetime('now')";
			else if (days == 14)
				query = "SELECT SUM(seconds) AS seconds FROM games_sessions_history WHERE `datetime_start` BETWEEN datetime('now', '-14 day') AND datetime('now')";
			else if (days == 30)
				query = "SELECT SUM(seconds) AS seconds FROM games_sessions_history WHERE `datetime_start` BETWEEN datetime('now', '-30 day') AND datetime('now')";
			else
				query = "SELECT SUM(seconds) AS seconds FROM games_sessions_history WHERE `datetime_start` BETWEEN datetime('now', '-365 day') AND datetime('now')";
		} else {
			if (days == 1)
				query = "SELECT SUM(seconds) AS seconds FROM games_sessions_history WHERE `datetime_start` BETWEEN datetime('now', '-1 day') AND datetime('now') AND game_id = "
						+ gameId;
			else if (days == 7)
				query = "SELECT SUM(seconds) AS seconds FROM games_sessions_history WHERE `datetime_start` BETWEEN datetime('now', '-7 day') AND datetime('now') AND game_id = "
						+ gameId;
			else if (days == 14)
				query = "SELECT SUM(seconds) AS seconds FROM games_sessions_history WHERE `datetime_start` BETWEEN datetime('now', '-14 day') AND datetime('now') AND game_id = "
						+ gameId;
			else if (days == 30)
				query = "SELECT SUM(seconds) AS seconds FROM games_sessions_history WHERE `datetime_start` BETWEEN datetime('now', '-30 day') AND datetime('now') AND game_id = "
						+ gameId;
			else
				query = "SELECT SUM(seconds) AS seconds FROM games_sessions_history WHERE `datetime_start` BETWEEN datetime('now', '-365 day') AND datetime('now') AND game_id = "
						+ gameId;
		}

		try (Connection con = DriverManager.getConnection(Utils.DATABASE_URL);
				PreparedStatement ps = con.prepareStatement(query)) {
			ResultSet rs = ps.executeQuery();
			return rs.getInt("seconds");
		} catch (SQLException e) {
			ErrorHandler.handle(e);
		}
		return 0;
	}
}
