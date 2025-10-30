package com.post_hub.i_am_service.service;

import com.post_hub.i_am_service.model.dto.Post.PostDTO;
import com.post_hub.i_am_service.model.dto.Post.PostSearchDTO;
import com.post_hub.i_am_service.model.request.post.PostRequest;
import com.post_hub.i_am_service.model.request.post.PostSearchRequest;
import com.post_hub.i_am_service.model.request.post.UpdatePostRequest;
import com.post_hub.i_am_service.model.response.IamResponse;
import com.post_hub.i_am_service.model.response.PaginationResponse;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Pageable;


public interface PostService {
    IamResponse<PostDTO> getById(@NotNull Integer postId);

    IamResponse<PostDTO> createPost(@NotNull Integer userId,@NotNull PostRequest post);

    IamResponse<PostDTO> updatePost(@NotNull Integer postId, @NotNull UpdatePostRequest updatePostRequest);

    void softDeletePost(@NotNull Integer postId);

    IamResponse<PaginationResponse<PostSearchDTO>> findAllPosts(Pageable pageable);

    IamResponse<PaginationResponse<PostSearchDTO>> searchPosts(@NotNull PostSearchRequest postSearchRequest, Pageable pageable);

}
