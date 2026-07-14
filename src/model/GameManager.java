package model;

import dao.GameDAO;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
	private List<Game> games = new ArrayList<>();
	
	public void loadGames() {
		GameDAO dao = new GameDAO();
		games = dao.getAllGames();
	}
	
	public List<Game> getGames() {
		return games;
	}

}
