package repository;

import model.Game;
import dao.GameDAO;

import java.util.ArrayList;
import java.util.List;

public class GameRepository {
    public List<Game> games_list = new ArrayList<>();

    public GameRepository() {
        GameDAO gameDao = new GameDAO();
        games_list = gameDao.getAll();
    }
	
	public List<Game> getList() {
		return games_list;
	}
}
