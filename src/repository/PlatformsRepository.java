package repository;

import dao.PlatformsDAO;
import model.Platforms;

import java.util.ArrayList;
import java.util.List;

public class PlatformsRepository {
    public List<Platforms> platforms_list = new ArrayList<>();

    public PlatformsRepository() {
        PlatformsDAO repositoriesDao = new PlatformsDAO();
        platforms_list = repositoriesDao.getAll();
    }

    public List<Platforms> getList() {
        return platforms_list;
    }
}
