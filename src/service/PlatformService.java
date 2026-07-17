package service;

import app.Main;

public class PlatformService {
    public int findIdByName(String name) {
        for(int i=0; i<Main.platformsRepository.platforms_list.size(); i++) {
            if(Main.platformsRepository.platforms_list.get(i).getName().equals(name)) return Main.platformsRepository.platforms_list.get(i).getId();
        }
        return 0;
    }
        

    public String findNameById(int id) {
        for(int i=0; i<Main.platformsRepository.platforms_list.size(); i++) {
            if(Main.platformsRepository.platforms_list.get(i).getId() == id) return Main.platformsRepository.platforms_list.get(i).getName();
        }
        return "ERROR";
    }
}
