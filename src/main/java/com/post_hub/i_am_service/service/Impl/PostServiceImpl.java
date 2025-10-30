package com.post_hub.i_am_service.service.Impl;

import com.post_hub.i_am_service.mapper.PostMapper;
import com.post_hub.i_am_service.model.constants.ApiErrorMessage;
import com.post_hub.i_am_service.model.dto.Post.PostDTO;
import com.post_hub.i_am_service.model.dto.Post.PostSearchDTO;
import com.post_hub.i_am_service.model.entity.Post;
import com.post_hub.i_am_service.model.entity.User;
import com.post_hub.i_am_service.model.exception.DataExistsException;
import com.post_hub.i_am_service.model.exception.NotFoundException;
import com.post_hub.i_am_service.model.request.post.PostRequest;
import com.post_hub.i_am_service.model.request.post.PostSearchRequest;
import com.post_hub.i_am_service.model.request.post.UpdatePostRequest;
import com.post_hub.i_am_service.model.response.IamResponse;
import com.post_hub.i_am_service.model.response.PaginationResponse;
import com.post_hub.i_am_service.repositories.PostRepository;
import com.post_hub.i_am_service.repositories.UserRepository;
import com.post_hub.i_am_service.repositories.criteria.PostSearchCriteria;
import com.post_hub.i_am_service.service.PostService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final PostMapper postMapper;

    @Override
    public IamResponse<PostDTO> getById(@NotNull Integer postId) {
        Post post = postRepository.findByIdAndDeletedFalse(postId).orElseThrow(
                () -> new NotFoundException(ApiErrorMessage
                        .POST_NOT_FOUND_BY_ID.getMessage(postId)));

        PostDTO postDTO = postMapper.toPostDto(post);
        return IamResponse.createSuccessful(postDTO);
    }

    @Override
    public IamResponse<PostDTO> createPost(@NotNull Integer userId, @NotNull PostRequest postRequest) {
        if (postRepository.existsByTitle(postRequest.getTitle())) {
            throw new DataExistsException(ApiErrorMessage
                    .POST_ALREADY_EXISTS.getMessage(postRequest.getTitle()));
        }
        User user = userRepository.findById(userId).orElseThrow(
                () -> new NotFoundException(ApiErrorMessage.POST_NOT_FOUND_BY_ID.getMessage(userId)));
        Post post = postMapper.toEntity(postRequest, user);
        Post savedPost = postRepository.save(post);
        PostDTO postDto = postMapper.toPostDto(savedPost);
        return IamResponse.createSuccessful(postDto);
    }

    @Override
    public IamResponse<PostDTO> updatePost(@NotNull Integer postId, UpdatePostRequest updatePostRequest) {
        Post post = postRepository.findByIdAndDeletedFalse(postId).orElseThrow(
                () -> new NotFoundException(ApiErrorMessage.POST_NOT_FOUND_BY_ID.getMessage(postId)));
        postMapper.updatePost(post, updatePostRequest);
        post.setUpdated(LocalDateTime.now());
        postRepository.save(post);
        PostDTO postdto = postMapper.toPostDto(post);
        return IamResponse.createSuccessful(postdto);
    }

    @Override
    public void softDeletePost(Integer postId) {
        Post post = postRepository.findByIdAndDeletedFalse(postId).orElseThrow(
                () -> new NotFoundException(ApiErrorMessage.POST_NOT_FOUND_BY_ID.getMessage(postId))
        );
        post.setDeleted(true);
        postRepository.save(post);
    }

    @Override
    public IamResponse<PaginationResponse<PostSearchDTO>> findAllPosts(Pageable pageable) {
        Page<PostSearchDTO> posts = postRepository.findAll(pageable)
                .map(postMapper::toPostSearchDTO);

        PaginationResponse<PostSearchDTO> paginationResponse = new PaginationResponse<>(
                posts.getContent(),
                new PaginationResponse.Pagination(
                        posts.getTotalElements(),
                        pageable.getPageSize(),
                        posts.getNumber() + 1,
                        posts.getTotalPages()
                )

        );
        return IamResponse.createSuccessful(paginationResponse);
    }

    @Override
    public IamResponse<PaginationResponse<PostSearchDTO>> searchPosts(PostSearchRequest postSearchRequest, Pageable pageable) {
        Specification<Post> specification = new PostSearchCriteria(postSearchRequest);
        Page<PostSearchDTO> posts = postRepository.findAll(specification, pageable)
                .map(postMapper::toPostSearchDTO);

        PaginationResponse<PostSearchDTO> paginationResponse = PaginationResponse.<PostSearchDTO>builder()
                .content(posts.getContent())
                .pagination(PaginationResponse.Pagination.builder()
                        .total(posts.getTotalElements())
                        .limit(pageable.getPageSize())
                        .page(posts.getNumber() + 1)
                        .build()).build();
        return IamResponse.createSuccessful(paginationResponse);
    }


}
