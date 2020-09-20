package com.example.ecom.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * Authentication controller.
 *
 * @author Gangani
 * @version 1.0
 * @since 2020-09-19
 */

public class RefreshTokenRequestDto {
    private String userName;
    @JsonProperty("refresh_token")
    private String refreshToken;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, refreshToken);
    }

    @Override
    public String toString() {
        return "RefreshTokenRequestDTO{"
                + "userName='" + userName + '\''
                + ", refreshToken='" + refreshToken + '\''
                + '}';
    }
}
