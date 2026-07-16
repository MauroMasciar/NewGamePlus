package model;

public class Platforms {
    private int id;
    private String name;
    private int timePlayed;
    private int totalSessions;
    
    public Platforms(int id, String name, int timePlayed, int totalSessions) {
        this.id = id;
        this.name = name;
        this.timePlayed = timePlayed;
        this.totalSessions = totalSessions;
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

    public int getTotalSessions() {
        return totalSessions;
    }

    public void setTotalSessions(int totalSessions) {
        this.totalSessions = totalSessions;
    }
}
