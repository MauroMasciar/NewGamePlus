package com.masciar.model.steam.GetSchemaForGame;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetSchemaForGameResponse {
    private GetSchemaForGameData game;

    public GetSchemaForGameResponse() {
    }

    public GetSchemaForGameData getGame() {
        return game;
    }

    public void setGame(GetSchemaForGameData game) {
        this.game = game;
    }
}
