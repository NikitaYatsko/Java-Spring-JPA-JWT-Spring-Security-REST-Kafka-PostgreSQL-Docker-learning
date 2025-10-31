package com.post_hub.i_am_service.model.request.user;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

@Data
public class UpdateUserRequest implements Serializable {
    @NotNull
    @Size(max = 30)
    private String username;
}
