package com.post_hub.i_am_service.service;

import com.post_hub.i_am_service.model.dto.Post.PostDTO;
import com.post_hub.i_am_service.model.request.PostRequest;
import com.post_hub.i_am_service.model.request.UpdatePostRequest;
import com.post_hub.i_am_service.model.response.IamResponse;
import jakarta.validation.constraints.NotNull;


public interface PostService {
    IamResponse<PostDTO> getById(@NotNull Integer postId);

    IamResponse<PostDTO> createPost(@NotNull PostRequest post);

    IamResponse<PostDTO> updatePost(@NotNull Integer postId, @NotNull UpdatePostRequest updatePostRequest);
}
