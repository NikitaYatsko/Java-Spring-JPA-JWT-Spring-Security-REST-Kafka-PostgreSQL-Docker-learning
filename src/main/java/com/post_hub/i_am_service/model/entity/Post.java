package com.post_hub.i_am_service.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "posts")
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false, length = 500)
    private String content;
    @Column(nullable = false, updatable = false)
    private LocalDateTime created = LocalDateTime.now();
    @Column(nullable = false, columnDefinition = "integer default 0")
    private Integer likes = 0;
}
