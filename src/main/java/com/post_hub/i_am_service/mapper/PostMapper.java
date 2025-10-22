package com.post_hub.i_am_service.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.post_hub.i_am_service.model.dto.Post.PostDTO;
import com.post_hub.i_am_service.model.entity.Post;
import com.post_hub.i_am_service.model.request.PostRequest;
import org.hibernate.type.descriptor.DateTimeUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, imports = {DateTimeUtils.class, ObjectMapper.class})
public interface PostMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "content", target = "content")
    @Mapping(source = "likes", target = "likes")
    @Mapping(source = "created", target = "created", dateFormat = "yyyy-MM-dd'T'HH:mm:ss")
    PostDTO toPostDto(Post post);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "created", ignore = true)
    Post toEntity(PostRequest postRequest);
}