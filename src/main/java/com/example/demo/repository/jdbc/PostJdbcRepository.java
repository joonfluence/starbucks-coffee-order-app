package com.example.demo.repository.jdbc;

import com.example.demo.domain.Post;
import com.example.demo.dto.post.PostSaveDto;
import com.example.demo.dto.post.PostUpdateDto;
import com.example.demo.repository.PostRepository;

import java.util.List;

public class PostJdbcRepository implements PostRepository {

    @Override
    public Long save(PostSaveDto dto) {
        return null;
    }

    @Override
    public Post findById(Long postId) {
        return null;
    }

    @Override
    public List<Post> findAll() {
        return null;
    }

    @Override
    public void update(PostUpdateDto dto) {

    }

    @Override
    public void delete(Post post) {

    }
}
