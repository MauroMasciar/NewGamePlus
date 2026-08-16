package com.masciar.model;

public class History {
    private int id;
    private String token;
    private int gameId;
    private String gameName;
    private int libraryId;
    private int platformId;
    private String dateTimeStart;
    private String dateTimeEnd;
    private int seconds;
    private String gameVersion;

    public History(int id, String token, int gameId, String gameName, int libraryId, int platformId, String dateTimeStart, String dateTimeEnd, int seconds, String gameVersion) {
        this.id = id;
        this.token = token;
        this.gameId = gameId;
        this.gameName = gameName;
        this.libraryId = libraryId;
        this.platformId = platformId;
        this.dateTimeStart = dateTimeStart;
        this.dateTimeEnd = dateTimeEnd;
        this.seconds = seconds;
        this.gameVersion = gameVersion;
    }

    public int getId() {
        return id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public int getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(int libraryId) {
        this.libraryId = libraryId;
    }

    public int getPlatformId() {
        return platformId;
    }

    public void setPlatformId(int platformId) {
        this.platformId = platformId;
    }

    public String getDateTimeStart() {
        return dateTimeStart;
    }

    public void setDateTimeStart(String dateTimeStart) {
        this.dateTimeStart = dateTimeStart;
    }

    public String getDateTimeEnd() {
        return dateTimeEnd;
    }

    public void setDateTimeEnd(String dateTimeEnd) {
        this.dateTimeEnd = dateTimeEnd;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public String getGameVersion() {
        return gameVersion;
    }

    public void setGameVersion(String gameVersion) {
        this.gameVersion = gameVersion;
    }
}
