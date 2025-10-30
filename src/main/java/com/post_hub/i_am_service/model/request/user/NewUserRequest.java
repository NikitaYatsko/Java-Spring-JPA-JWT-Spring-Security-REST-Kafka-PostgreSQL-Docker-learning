package com.post_hub.i_am_service.model.request.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class NewUserRequest {
    @NotBlank(message = "Username can't be empty")
    @Size(max = 30)
    private String username;
    @NotBlank(message = "User must have a password")
    @Size(max = 50)
    private String password;
    @NotBlank(message = "E-mail is necessary")
    @Size(max = 50)
    private String email;
}
