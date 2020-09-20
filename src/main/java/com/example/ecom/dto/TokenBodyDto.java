package com.example.ecom.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * Authentication controller.
 *
 * @author Gangani
 * @version 1.0
 * @since 2020-09-19
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class TokenBodyDto {
    @JsonProperty("preferred_username")
    private String preferredUsername;
    @JsonProperty("realm_access")
    private TokenRolesDto realmAccess;

    public String getPreferredUsername() {
        return preferredUsername;
    }

    public void setPreferredUsername(String preferredUsername) {
        this.preferredUsername = preferredUsername;
    }

    public TokenRolesDto getRealmAccess() {
        return realmAccess;
    }

    public void setRealmAccess(TokenRolesDto realmAccess) {
        this.realmAccess = realmAccess;
    }

    @Override
    public int hashCode() {
        return Objects.hash(preferredUsername, realmAccess);
    }

    @Override
    public String toString() {
        return "TokenBodyDTO{"
                + "preferredUsername='" + preferredUsername + '\''
                + ", realmAccess=" + realmAccess
                + '}';
    }
}
