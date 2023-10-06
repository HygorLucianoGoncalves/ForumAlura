package com.hygorluciano.forumalura.domain.model;

import lombok.Getter;

@Getter
public enum UsuarioRole {
    ADMIN("admin"),
    USER("user");

    private final String role;

    UsuarioRole(String role) {
        this.role = role;
    }

}
