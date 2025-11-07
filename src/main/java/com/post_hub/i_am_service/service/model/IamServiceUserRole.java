package com.post_hub.i_am_service.service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum IamServiceUserRole {
    USER("USER"),
    SUPER_ADMIN("SUPER_ADMIN"),
    ADMIN("ADMIN");

    private final String role;

    public static IamServiceUserRole fromName(String name) {
        return IamServiceUserRole.valueOf(name);
    }
}
