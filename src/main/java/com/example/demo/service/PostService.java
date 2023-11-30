package com.example.demo.service;

import com.example.demo.dto.post.PostSaveDto;
import com.example.demo.dto.post.PostUpdateDto;

public interface PostService {
    Long createPost(PostSaveDto dto);
    void sendLike(PostUpdateDto dto);
}
