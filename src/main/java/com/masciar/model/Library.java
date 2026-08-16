package com.masciar.model;

public class Library {
    private int id;
    private String name;
    private int timePlayed;
    private int totalSession;

    public Library(int id, String name, int timePlayed, int totalSession) {
        this.id = id;
        this.name = name;
        this.timePlayed = timePlayed;
        this.totalSession = totalSession;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTimePlayed() {
        return timePlayed;
    }

    public void setTimePlayed(int timePlayed) {
        this.timePlayed = timePlayed;
    }

    public int getTotalSession() {
        return totalSession;
    }

    public void setTotalSession(int totalSession) {
        this.totalSession = totalSession;
    }

}
