package com.masciar.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.masciar.app.ApiSteamKey;
import com.masciar.model.steam.vanity.ResolveVanityResponse;
import com.masciar.model.steam.vanity.VanityModel;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SteamService {
    ApiSteamKey apiSteamKey = new ApiSteamKey();
    private String API_KEY = apiSteamKey.GetApiSteamKey();

    public String getSteamId(String name) {
        String url = String.format("https://api.steampowered.com/ISteamUser/ResolveVanityURL/v1/?key=%s&vanityurl=%s", API_KEY, name);

        HttpClient client = HttpClient.newHttpClient(); // creo un cliente
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build(); // envio un get para que me de el objeto
        HttpResponse<String> response; // aca guardo lo que me devolvio: codigo, header y body
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            ObjectMapper mapper = new ObjectMapper();
            String json = response.body(); // aca toma lo que esta dentro del body, osea el json
            ResolveVanityResponse steamResponse = mapper.readValue(json, ResolveVanityResponse.class);
            VanityModel vanity = steamResponse.getResponse();
            if(vanity.getSuccess() == 1) return vanity.getSteamid();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return "0";
    }

    public void getPlayerAchievements() {
        String steamId = "76561198201938341";
        int appId = 813780;

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
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
