package com.masciar.model.steam.vanity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResolveVanityResponse {

    private VanityModel response;

    public ResolveVanityResponse() {
    }

    public VanityModel getResponse() {
        return response;
    }

    public void setResponse(VanityModel response) {
        this.response = response;
    }
}