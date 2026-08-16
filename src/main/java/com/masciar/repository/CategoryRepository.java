package com.masciar.repository;

import com.masciar.dao.CategoryDAO;
import com.masciar.model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryRepository {
    public List<Category> categories_list = new ArrayList<>();

    public CategoryRepository() {
        CategoryDAO categoryDao = new CategoryDAO();
        categories_list = categoryDao.getAll();
    }

    public List<Category> getList() {
        return categories_list;
    }
}
