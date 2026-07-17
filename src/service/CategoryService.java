package service;

import app.Main;

public class CategoryService {
    public int findIdByName(String name) {
        for(int i=0; i<Main.categoryRepository.categories_list.size(); i++) {
            if(Main.categoryRepository.categories_list.get(i).getName().equals(name)) return Main.categoryRepository.categories_list.get(i).getId();
        }
        return 0;
    }
        

    public String findNameById(int id) {
        for(int i=0; i<Main.categoryRepository.categories_list.size(); i++) {
            if(Main.categoryRepository.categories_list.get(i).getId() == id) return Main.categoryRepository.categories_list.get(i).getName();
        }
        return "ERROR";
    }
}
