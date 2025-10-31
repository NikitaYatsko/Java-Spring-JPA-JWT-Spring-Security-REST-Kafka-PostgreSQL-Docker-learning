package com.post_hub.i_am_service.repositories;

import com.post_hub.i_am_service.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

   Optional<User> findByIdAndDeletedFalse(Integer id);

}
