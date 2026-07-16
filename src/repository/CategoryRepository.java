package repository;

import dao.CategoriesDAO;
import model.Categories;

import java.util.ArrayList;
import java.util.List;

public class CategoryRepository {
    public List<Categories> categories_list = new ArrayList<>();

    public CategoryRepository() {
        CategoriesDAO categoryDao = new CategoriesDAO();
        categories_list = categoryDao.getAll();
    }

    public List<Categories> getList() {
        return categories_list;
    }
}
