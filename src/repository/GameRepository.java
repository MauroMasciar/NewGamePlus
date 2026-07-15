package repository;

import model.Game;
import dao.GameDAO;

import java.util.ArrayList;
import java.util.List;

public class GameRepository {
    public List<Game> games_list = new ArrayList<>();

    public GameRepository() {
        GameDAO games = new GameDAO();
        games_list = games.getAllGames();
    }
	
	public List<Game> getGames() {
		return games_list;
	}
}
