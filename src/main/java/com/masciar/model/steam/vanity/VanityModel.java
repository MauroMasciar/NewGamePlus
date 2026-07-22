package com.masciar.model.steam.vanity;

public class VanityModel {
    private String steamid;
    private int success;

    public VanityModel() { }

    public VanityModel(String steamid, int success) {
        this.steamid = steamid;
        this.success = success;
    }

    public String getSteamid() {
        return steamid;
    }

    public void setSteamid(String steamid) {
        this.steamid = steamid;
    }

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }
}
