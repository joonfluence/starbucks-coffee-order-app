package com.example.demo.repository;

import com.example.demo.domain.Post;
import com.example.demo.dto.post.PostSaveDto;
import com.example.demo.dto.post.PostUpdateDto;

import java.util.List;

public interface PostRepository {
    Long save(PostSaveDto dto);

    Post findById(Long postId);

    List<Post> findAll();

    void update(PostUpdateDto dto);

    void delete(Post post);
}
