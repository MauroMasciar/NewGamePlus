package com.masciar.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SteamService {
    private static final String API_KEY = "TU_API_KEY";

    public void GetPlayerAchievements() {
        String steamId = "76561198000000000";
        int appId = 220;

        String url = String.format(
                "https://api.steampowered.com/ISteamUserStats/GetPlayerAchievements/v1/?key=%s&steamid=%s&appid=%d",
                API_KEY,
                steamId,
                appId);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (InterruptedException e) {

        } catch (IOException e) {

        }
    }
}
