package com.masciar.dao;

import com.masciar.logging.ErrorHandler;
import com.masciar.util.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GamesSessionBackupDAO {
    public void saveBackup(int gameId, String dateTimeString, int seconds) {
        String query = "DELETE FROM games_session_backup";
        try (Connection con = DriverManager.getConnection(Utils.DATABASE_URL);
                PreparedStatement ps = con.prepareStatement(query)) {
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected != 0)
                System.out.println("Backup antiguo borrado");
            else
                System.out.println("Error al borrar backup antiguo");
        } catch (SQLException e) {
            ErrorHandler.handle(e);
        }

        query = "INSERT INTO games_session_backup (game_id, date_time, seconds) VALUES (?, ?, ?)";
        try (Connection con = DriverManager.getConnection(Utils.DATABASE_URL);
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, gameId);
            ps.setString(2, dateTimeString);
            ps.setInt(3, seconds);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected != 0)
                System.out.println("Backup de la sesion creada");
            else
                System.out.println("Fallo al crear el backup de la sesion");
        } catch (SQLException e) {
            ErrorHandler.handle(e);
        }
    }
}
