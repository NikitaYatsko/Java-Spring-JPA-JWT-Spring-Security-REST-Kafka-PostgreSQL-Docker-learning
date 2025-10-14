package com.post_hub.i_am_service.repositories;

import com.post_hub.i_am_service.model.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
