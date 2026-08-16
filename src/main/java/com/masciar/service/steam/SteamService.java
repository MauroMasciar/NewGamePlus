package com.masciar.service.steam;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.masciar.app.ApiSteamKey;
import com.masciar.app.Main;
import com.masciar.logging.ErrorHandler;
import com.masciar.model.steam.GetOwnedGames.GameModel;
import com.masciar.model.steam.GetOwnedGames.GetOwnedGamesResponse;
import com.masciar.model.steam.vanity.ResolveVanityResponse;
import com.masciar.model.steam.vanity.VanityModel;
import com.masciar.service.ConfigService;
import com.masciar.util.Utils;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

public class SteamService {
    private ApiSteamKey apiSteamKey = new ApiSteamKey();
    private String API_KEY = apiSteamKey.getApiSteamKey();
    private String steamId64 = ConfigService.getProperty("steam.id");

    public String getSteamID64(String name) {
        String url = String.format("https://api.steampowered.com/ISteamUser/ResolveVanityURL/v1/?key=%s&vanityurl=%s",
                API_KEY, name);

        HttpClient client = HttpClient.newHttpClient(); // creo un cliente
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build(); // envio un get para que me de el objeto
        HttpResponse<String> response; // aca guardo lo que me devolvio: codigo, header y body
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            ObjectMapper mapper = new ObjectMapper();
            String json = response.body(); // aca toma lo que esta dentro del body, osea el json
            ResolveVanityResponse steamResponse = mapper.readValue(json, ResolveVanityResponse.class);
            VanityModel vanity = steamResponse.getResponse();
            if (vanity.getSuccess() == 1)
                return vanity.getSteamid();
        } catch (IOException | InterruptedException e) {
            ErrorHandler.handle(e);
        }
        return "0";
    }

    public List<GameModel> getOwnedGames() {
        HttpClient client = HttpClient.newHttpClient();
        ObjectMapper mapper = new ObjectMapper();
        String url = String.format(
                "https://api.steampowered.com/IPlayerService/GetOwnedGames/v1/?key=%s&steamid=%s&include_appinfo=true", API_KEY, steamId64);

        try {
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            GetOwnedGamesResponse steamResponse = mapper.readValue(response.body(), GetOwnedGamesResponse.class);
            return steamResponse.getResponse().getGames();
        } catch (IOException | InterruptedException e) {
            ErrorHandler.handle(e);
        }
        return null;
    }

    public void getPlayerGameAchievements(int appId) {
        String url = String.format("https://api.steampowered.com/ISteamUserStats/GetPlayerAchievements/v1/?key=%s&steamid=%s&appid=%d", API_KEY, steamId64, appId);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (IOException | InterruptedException e) {
            ErrorHandler.handle(e);
        }
    }

    public void getAchievementsGame(int appId) {
        String url = String.format("https://api.steampowered.com/ISteamUserStats/GetSchemaForGame/v2/?key=%s&appid=%d&l=spanish", API_KEY, appId);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (IOException | InterruptedException e) {
            ErrorHandler.handle(e);
        }
    }

    public void assignAppIdToGame() {
        for (int i = 0; i < Main.steamGamesRepository.game_list.size(); i++) {
            for (int g = 0; g < Main.gameRepository.games_list.size(); g++) {
                if (Main.gameRepository.games_list.get(g).getName().equals(Main.steamGamesRepository.game_list.get(i).getName())) {
                    String query = "UPDATE games SET steam_id = ? WHERE name = ?";
                    try (Connection con = DriverManager.getConnection(Utils.DATABASE_URL);
                            PreparedStatement ps = con.prepareStatement(query)) {
                        ps.setInt(1, Main.steamGamesRepository.getList().get(i).getAppId());
                        ps.setString(2, Main.gameRepository.games_list.get(g).getName());
                        ps.executeUpdate();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
