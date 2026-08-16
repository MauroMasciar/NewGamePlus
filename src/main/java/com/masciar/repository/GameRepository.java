package com.masciar.repository;

import com.masciar.model.Game;
import com.masciar.dao.GamesDAO;

import java.util.ArrayList;
import java.util.List;

public class GameRepository {
    public List<Game> games_list = new ArrayList<>();

    public GameRepository() {
        GamesDAO gameDao = new GamesDAO();
        games_list = gameDao.getAll();
    }
	
	public List<Game> getList() {
		return games_list;
	}
}
