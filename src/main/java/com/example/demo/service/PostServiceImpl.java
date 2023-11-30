package com.example.demo.service;

import com.example.demo.domain.Post;
import com.example.demo.dto.post.PostSaveDto;
import com.example.demo.dto.post.PostUpdateDto;
import com.example.demo.repository.PostRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final NotificationService notificationService;

    @Override
    public Long createPost(PostSaveDto dto) {
        return postRepository.save(dto);
    }

    @Override
    public void sendLike(PostUpdateDto dto) {
        postRepository.update(dto);
        Post post = postRepository.findById(dto.getId());
        notificationService.NotifyUser(post.getMember().getId());
    }
}
