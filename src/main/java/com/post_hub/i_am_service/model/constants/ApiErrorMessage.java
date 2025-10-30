package com.post_hub.i_am_service.model.constants;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ApiErrorMessage {
    POST_NOT_FOUND_BY_ID("Post with ID: %s not found"),
    POST_ALREADY_EXISTS("Post already exists"),
    USER_NOT_FOUND_BY_ID("User with ID: %s not found"),
    USERNAME_ALREADY_EXISTS("Username: %s already Exists"),
    EMAIL_ALREADY_EXISTS("E-mail: %s already Exists");

    private String message;

    public String getMessage(Object... args) {
        return String.format(message, args);
    }
}
