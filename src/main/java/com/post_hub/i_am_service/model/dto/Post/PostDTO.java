package com.post_hub.i_am_service.model.dto.Post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO implements Serializable {
    private Integer id;
    private String title;
    private String content;
    private Integer likes;
    private LocalDateTime created;
    private String createdBy;

}
