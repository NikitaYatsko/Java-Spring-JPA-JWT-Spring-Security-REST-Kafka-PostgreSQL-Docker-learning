package com.post_hub.i_am_service.mapper;

import com.post_hub.i_am_service.model.dto.User.UserDTO;
import com.post_hub.i_am_service.model.entity.User;
import com.post_hub.i_am_service.model.enums.RegistrationStatus;
import com.post_hub.i_am_service.model.request.user.NewUserRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
imports = {RegistrationStatus.class, Object.class})
public interface UserMapper {
    UserDTO toDto(User user);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "created", ignore = true)
    @Mapping(target = "registrationStatus", expression = "java(RegistrationStatus.ACTIVE)")
    User toEntity(NewUserRequest newUserRequest);

}
