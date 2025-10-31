package com.post_hub.i_am_service.service;

import com.post_hub.i_am_service.model.dto.User.UserDTO;
import com.post_hub.i_am_service.model.request.user.NewUserRequest;
import com.post_hub.i_am_service.model.request.user.UpdateUserRequest;
import com.post_hub.i_am_service.model.response.IamResponse;
import jakarta.validation.constraints.NotNull;

public interface UserService {
    IamResponse<UserDTO> getById(@NotNull Integer userId);

    IamResponse<UserDTO> createUser(@NotNull NewUserRequest request);
    IamResponse<UserDTO> updateUser(@NotNull Integer userId, @NotNull UpdateUserRequest request);
    void softDeleteUser(@NotNull Integer userId);
}
