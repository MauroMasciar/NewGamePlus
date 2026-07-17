package service;

import app.Main;

public class LibraryService {
    public int findIdByName(String name) {
        for(int i=0; i<Main.librariesRepository.library_list.size(); i++) {
            if(Main.librariesRepository.library_list.get(i).getName().equals(name)) return Main.librariesRepository.library_list.get(i).getId();
        }
        return 0;
    }
        

    public String findNameById(int id) {
        for(int i=0; i<Main.librariesRepository.library_list.size(); i++) {
            if(Main.librariesRepository.library_list.get(i).getId() == id) return Main.librariesRepository.library_list.get(i).getName();
        }
        return "ERROR";
    }
}
