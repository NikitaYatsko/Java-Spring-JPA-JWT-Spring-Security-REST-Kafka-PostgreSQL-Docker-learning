package com.post_hub.i_am_service.service.Impl;

import com.post_hub.i_am_service.mapper.UserMapper;
import com.post_hub.i_am_service.model.constants.ApiErrorMessage;
import com.post_hub.i_am_service.model.dto.User.UserDTO;
import com.post_hub.i_am_service.model.entity.User;
import com.post_hub.i_am_service.model.exception.DataExistsException;
import com.post_hub.i_am_service.model.exception.NotFoundException;
import com.post_hub.i_am_service.model.request.user.NewUserRequest;
import com.post_hub.i_am_service.model.request.user.UpdateUserRequest;
import com.post_hub.i_am_service.model.response.IamResponse;
import com.post_hub.i_am_service.repositories.UserRepository;
import com.post_hub.i_am_service.service.UserService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public IamResponse<UserDTO> getById(@NotNull Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new NotFoundException(ApiErrorMessage.USER_NOT_FOUND_BY_ID.getMessage(userId))
        );
        UserDTO dto = userMapper.toDto(user);
        return IamResponse.createSuccessful(dto);
    }

    @Override
    public IamResponse<UserDTO> createUser(NewUserRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new DataExistsException(ApiErrorMessage.EMAIL_ALREADY_EXISTS.getMessage(request.getEmail()));
        }

        if (userRepository.existsByUsername(request.getUsername())) {
            throw new DataExistsException(ApiErrorMessage.USERNAME_ALREADY_EXISTS.getMessage(request.getUsername()));
        }

        User userToSave = userMapper.toEntity(request);
        userRepository.save(userToSave);
        UserDTO response = userMapper.toDto(userToSave);
        return IamResponse.createSuccessful(response);
    }

    @Override
    public IamResponse<UserDTO> updateUser(@NotNull Integer userId, @NotNull UpdateUserRequest request) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new NotFoundException(ApiErrorMessage.USER_NOT_FOUND_BY_ID.getMessage(userId))
        );
        userMapper.updateUser(user, request);
        user.setUpdated(LocalDateTime.now());
        userRepository.save(user);
        UserDTO dto = userMapper.toDto(user);
        return IamResponse.createSuccessful(dto);


    }
}
