package com.masciar.model;

public class SteamGame {
    private int id;
    private String name;
    private String imgIconUrl;
    private int appId;
    private int playtimeWindowsForever;
    private int playtimeLinuxForever;
    private int playtimeDeckForever;
    private int rtimeLastPlayed;
    private int contentDescriptorIds;
    private int playtimeDisconnected;

    public SteamGame(int id, String name, String imgIconUrl, int appId, int playtimeWindowsForever,
            int playtimeLinuxForever, int playtimeDeckForever, int rtimeLastPlayed,
            int contentDescriptorIds, int playtimeDisconnected) {
        this.id = id;
        this.name = name;
        this.imgIconUrl = imgIconUrl;
        this.appId = appId;
        this.playtimeWindowsForever = playtimeWindowsForever;
        this.playtimeLinuxForever = playtimeLinuxForever;
        this.playtimeDeckForever = playtimeDeckForever;
        this.rtimeLastPlayed = rtimeLastPlayed;
        this.contentDescriptorIds = contentDescriptorIds;
        this.playtimeDisconnected = playtimeDisconnected;
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

    public String getimgIconUrl() {
        return imgIconUrl;
    }

    public void setimgIconUrl(String imgIconUrl) {
        this.imgIconUrl = imgIconUrl;
    }

    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
    }

    public int getPlaytimeWindowsForever() {
        return playtimeWindowsForever;
    }

    public void setPlaytimeWindowsForever(int playtimeWindowsForever) {
        this.playtimeWindowsForever = playtimeWindowsForever;
    }

    public int getPlaytimeLinuxForever() {
        return playtimeLinuxForever;
    }

    public void setPlaytimeLinuxForever(int playtimeLinuxForever) {
        this.playtimeLinuxForever = playtimeLinuxForever;
    }

    public int getPlaytimeDeckForever() {
        return playtimeDeckForever;
    }

    public void setPlaytimeDeckForever(int playtimeDeckForever) {
        this.playtimeDeckForever = playtimeDeckForever;
    }

    public int getRtimeLastPlayed() {
        return rtimeLastPlayed;
    }

    public void setRtimeLastPlayed(int rtimeLastPlayed) {
        this.rtimeLastPlayed = rtimeLastPlayed;
    }

    public int getContentDescriptorIds() {
        return contentDescriptorIds;
    }

    public void setContentDescriptorIds(int contentDescriptorIds) {
        this.contentDescriptorIds = contentDescriptorIds;
    }

    public int getPlaytimeDisconnected() {
        return playtimeDisconnected;
    }

    public void setPlaytimeDisconnected(int playtimeDisconnected) {
        this.playtimeDisconnected = playtimeDisconnected;
    }
}
