package com.fcfm.backend.authentication.models;

public class AuthResponse {
    private String jwt;

    // Constructor, getter y setter

    public AuthResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
