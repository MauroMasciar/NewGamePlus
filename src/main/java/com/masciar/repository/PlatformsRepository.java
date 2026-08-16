package com.masciar.repository;

import com.masciar.dao.PlatformDAO;
import com.masciar.model.Platform;

import java.util.ArrayList;
import java.util.List;

public class PlatformsRepository {
    public List<Platform> platforms_list = new ArrayList<>();

    public PlatformsRepository() {
        PlatformDAO platformDao = new PlatformDAO();
        platforms_list = platformDao.getAll();
    }

    public List<Platform> getList() {
        return platforms_list;
    }
}
