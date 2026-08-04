package com.masciar.model.steam.GetOwnedGames;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GameModel {
    private int appid;
    private String name;
    private String img_icon_url;
    private int playtime_windows_forever;
    private int playtime_linux_forever;
    private int playtime_deck_forever;
    private long rtime_last_played;
    private List<Integer> content_descriptorids;
    private int playtime_disconnected;

    public GameModel() {
    }

    public GameModel(int appid,
            String name,
            String img_icon_url,
            int playtime_windows_forever,
            int playtime_linux_forever,
            int playtime_deck_forever,
            int rtime_last_played,
            List<Integer> content_descriptorids,
            int playtime_disconnected) {
        this.appid = appid;
        this.name = name;
        this.img_icon_url = img_icon_url;
        this.playtime_windows_forever = playtime_windows_forever;
        this.playtime_linux_forever = playtime_linux_forever;
        this.playtime_deck_forever = playtime_deck_forever;
        this.rtime_last_played = rtime_last_played;
        this.content_descriptorids = content_descriptorids;
        this.playtime_disconnected = playtime_disconnected;
    }

    public int getAppid() {
        return appid;
    }

    public void setAppid(int appid) {
        this.appid = appid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg_icon_url() {
        return img_icon_url;
    }

    public void setImg_icon_url(String img_icon_url) {
        this.img_icon_url = img_icon_url;
    }

    public int getPlaytime_windows_forever() {
        return playtime_windows_forever;
    }

    public void setPlaytime_windows_forever(int playtime_windows_forever) {
        this.playtime_windows_forever = playtime_windows_forever;
    }

    public int getPlaytime_linux_forever() {
        return playtime_linux_forever;
    }

    public void setPlaytime_linux_forever(int playtime_linux_forever) {
        this.playtime_linux_forever = playtime_linux_forever;
    }

    public int getPlaytime_deck_forever() {
        return playtime_deck_forever;
    }

    public void setPlaytime_deck_forever(int playtime_deck_forever) {
        this.playtime_deck_forever = playtime_deck_forever;
    }

    public long getRtime_last_played() {
        return rtime_last_played;
    }

    public void setRtime_last_played(int rtime_last_played) {
        this.rtime_last_played = rtime_last_played;
    }

    public List<Integer> getContent_descriptorids() {
        return content_descriptorids;
    }

    public void setContent_descriptorids(List<Integer> content_descriptorids) {
        this.content_descriptorids = content_descriptorids;
    }

    public int getPlaytime_disconnected() {
        return playtime_disconnected;
    }

    public void setPlaytime_disconnected(int playtime_disconnected) {
        this.playtime_disconnected = playtime_disconnected;
    }
}
