package com.post_hub.i_am_service.mapper;

import com.post_hub.i_am_service.model.dto.User.UserDTO;
import com.post_hub.i_am_service.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {

    UserDTO toDto(User user);
}
