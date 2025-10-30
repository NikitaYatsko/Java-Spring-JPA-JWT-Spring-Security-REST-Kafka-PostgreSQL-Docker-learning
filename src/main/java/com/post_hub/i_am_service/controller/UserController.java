package com.post_hub.i_am_service.controller;

import com.post_hub.i_am_service.model.constants.ApiLogMessage;
import com.post_hub.i_am_service.model.dto.User.UserDTO;
import com.post_hub.i_am_service.model.response.IamResponse;
import com.post_hub.i_am_service.service.UserService;
import com.post_hub.i_am_service.utils.ApiUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
