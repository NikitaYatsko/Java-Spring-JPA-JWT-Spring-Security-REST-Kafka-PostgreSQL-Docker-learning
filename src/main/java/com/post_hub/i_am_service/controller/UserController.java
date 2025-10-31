package com.post_hub.i_am_service.controller;

import com.post_hub.i_am_service.model.constants.ApiLogMessage;
import com.post_hub.i_am_service.model.dto.User.UserDTO;
import com.post_hub.i_am_service.model.request.user.NewUserRequest;
import com.post_hub.i_am_service.model.request.user.UpdateUserRequest;
import com.post_hub.i_am_service.model.response.IamResponse;
import com.post_hub.i_am_service.service.UserService;
import com.post_hub.i_am_service.utils.ApiUtils;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@Validated
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<IamResponse<UserDTO>> getUserById(@PathVariable(name = "id") Integer id) {
        log.trace(ApiLogMessage.NAME_OF_CURRENT_METHOD.getValue(), ApiUtils.getMethodName());
        IamResponse<UserDTO> response = userService.getById(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/create")
    public ResponseEntity<IamResponse<UserDTO>> createUser(@Valid @RequestBody NewUserRequest newUserRequest) {
        log.trace(ApiLogMessage.NAME_OF_CURRENT_METHOD.getValue(), ApiUtils.getMethodName());
        IamResponse<UserDTO> response = userService.createUser(newUserRequest);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<IamResponse<UserDTO>> updateUserById(@PathVariable(name = "id") Integer id, @Valid @RequestBody UpdateUserRequest updateUserRequest) {
        log.trace(ApiLogMessage.NAME_OF_CURRENT_METHOD.getValue(), ApiUtils.getMethodName());
        IamResponse<UserDTO> response = userService.updateUser(id, updateUserRequest);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> softDeleteUserById(@PathVariable(name = "id") Integer id) {
        log.trace(ApiLogMessage.NAME_OF_CURRENT_METHOD.getValue(), ApiUtils.getMethodName());
        userService.softDeleteUser(id);
        return ResponseEntity.ok().build();

    }
}
