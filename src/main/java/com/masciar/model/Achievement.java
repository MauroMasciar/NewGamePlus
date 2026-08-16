package com.masciar.model;

public class Achievement {
    private int id;
    private String gameName;
    private int gameId;
    private String description;
    private String date; 

    public Achievement(int id, String gameName, int gameId, String description, String date) {
        this.id = id;
        this.gameName = gameName;
        this.gameId = gameId;
        this.description = description;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
