package com.example.ecom.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Authentication controller.
 *
 * @author Gangani
 * @version 1.0
 * @since 2020-09-19
 */


@JsonIgnoreProperties(ignoreUnknown = true)
public class KeycloakLoginResponseDto {
    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("token_expires_in")
    private int tokenExpiresIn;
    @JsonProperty("session_state")
    private String sessionState;
    @JsonProperty("refresh_token")
    private String refreshToken;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public int getTokenExpiresIn() {
        return tokenExpiresIn;
    }

    public void setTokenExpiresIn(int tokenExpiresIn) {
        this.tokenExpiresIn = tokenExpiresIn;
    }

    public String getSessionState() {
        return sessionState;
    }

    public void setSessionState(String sessionState) {
        this.sessionState = sessionState;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }


    @Override
    public String toString() {
        return "KeycloakLoginResponseDto{" +
                "accessToken='" + accessToken + '\'' +
                ", tokenExpiresIn=" + tokenExpiresIn +
                ", sessionState='" + sessionState + '\'' +
                ", refreshToken='" + refreshToken + '\'' +
                '}';
    }
}
