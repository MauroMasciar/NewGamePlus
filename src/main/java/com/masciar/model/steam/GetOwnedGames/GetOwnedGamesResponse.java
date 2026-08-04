package com.masciar.model.steam.GetOwnedGames;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetOwnedGamesResponse {
    private OwnedGamesData response;

    public GetOwnedGamesResponse() {
    }

    public OwnedGamesData getResponse() {
        return response;
    }

    public void setResponse(OwnedGamesData response) {
        this.response = response;
    }
}
