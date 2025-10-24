package com.post_hub.i_am_service.repositories;

import com.post_hub.i_am_service.model.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Integer> {
    boolean existsByTitle(String title);
    Optional<Post> findByIdAndDeletedFalse(Integer id);
}
