package com.example.demo.repository.jpa;

import com.example.demo.domain.Member;
import com.example.demo.domain.Post;
import com.example.demo.dto.post.PostSaveDto;
import com.example.demo.dto.post.PostUpdateDto;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.PostRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
public class PostJpaRepository implements PostRepository {
    @PersistenceContext
    EntityManager em;

    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public Long save(PostSaveDto dto) {
        Member member = memberRepository.findById(dto.getMemberId());
        Post post = Post.builder().name(dto.getName()).member(member).build();
        em.persist(post);
        return post.getId();
    }

    @Override
    public Post findById(Long memberId) {
        return em.find(Post.class, memberId);
    }

    @Override
    public List<Post> findAll() {
        return em.createQuery("select p from Post p", Post.class).getResultList();
    }

    @Override
    @Transactional
    public void update(PostUpdateDto dto) {
        Post post = findById(dto.getId());
        Post newPost = Post.builder().id(dto.getId()).name(dto.getName()).likeCount(dto.getLikeCount()).build();
        post.update(newPost);
    }

    @Override
    public void delete(Post post) {
        em.remove(post);
    }
}