package com.masciar.repository;

import com.masciar.model.Achievement;
import com.masciar.dao.AchievementDAO;

import java.util.ArrayList;
import java.util.List;



public class AchievementRepository {
    public List<Achievement> achievementsList = new ArrayList<>();

    public AchievementRepository() {
        AchievementDAO achievementsDao = new AchievementDAO();
        achievementsDao.getAll();
    }

    public List<Achievement> getList() {
        return achievementsList;
    }
}
