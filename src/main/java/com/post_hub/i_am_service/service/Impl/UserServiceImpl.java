package com.post_hub.i_am_service.service.Impl;

import com.post_hub.i_am_service.mapper.UserMapper;
import com.post_hub.i_am_service.model.constants.ApiErrorMessage;
import com.post_hub.i_am_service.model.dto.User.UserDTO;
import com.post_hub.i_am_service.model.entity.User;
import com.post_hub.i_am_service.model.exception.NotFoundException;
import com.post_hub.i_am_service.model.response.IamResponse;
import com.post_hub.i_am_service.repositories.UserRepository;
import com.post_hub.i_am_service.service.UserService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
