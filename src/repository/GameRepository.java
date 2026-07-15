/*
    Obtener todos los juegos, ordenar, filtrar
    Pedir a DAO: Buscar, Agregar, Eliminar, Actualizar
 */

package repository;

import model.Game;
import dao.GameDAO;

import java.util.List;

public class GameRepository {
    public List<Game> games_list;

    public GameRepository() {
        GameDAO games = new GameDAO();
        games_list = games.getAllGames();
    }
}
