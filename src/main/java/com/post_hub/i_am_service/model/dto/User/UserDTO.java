package com.post_hub.i_am_service.model.dto.User;

import com.post_hub.i_am_service.model.enums.RegistrationStatus;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class UserDTO implements Serializable {
    private Integer id;
    private String username;
    private String email;
    private LocalDateTime created;
    private LocalDateTime lastLogin;
    private RegistrationStatus registrationStatus;
}
