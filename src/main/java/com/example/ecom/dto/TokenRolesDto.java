package com.example.ecom.dto;

import java.util.List;
import java.util.Objects;

/**
 * Authentication controller.
 *
 * @author Gangani
 * @version 1.0
 * @since 2020-09-19
 */

public class TokenRolesDto {
    private List<String> roles;

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TokenRolesDto that = (TokenRolesDto) o;
        return Objects.equals(roles, that.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roles);
    }

    @Override
    public String toString() {
        return "TokenRolesDTO{"
                + "roles=" + roles
                + '}';
    }
}
