package com.masciar.repository;

import com.masciar.dao.SteamDAO;
import com.masciar.model.SteamGame;

import java.util.ArrayList;
import java.util.List;

public class SteamGamesRepository {
    public List<SteamGame> game_list = new ArrayList<>();

    public SteamGamesRepository() {
        SteamDAO steamDao = new SteamDAO();
        game_list = steamDao.getAll();
    }

    public List<SteamGame> getList() {
        return game_list;
    }   
}
