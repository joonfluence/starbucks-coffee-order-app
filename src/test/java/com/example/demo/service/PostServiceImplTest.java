package com.example.demo.service;

import com.example.demo.domain.Post;
import com.example.demo.dto.member.MemberSaveDto;
import com.example.demo.dto.post.PostSaveDto;
import com.example.demo.dto.post.PostUpdateDto;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.jdbc.MemberJdbcRepository;
import com.example.demo.repository.jpa.PostJpaRepository;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

@Transactional
@SpringBootTest
class PostServiceImplTest {
    @Autowired
    PostService postService;
    @Autowired
    PostRepository postRepository;
    @Autowired
    MemberRepository memberRepository;

    @TestConfiguration
    static class TestConfig{
        @Bean
        public PostService postService(){
            return new PostServiceImpl(postRepository(), notificationService());
        }

        @Bean
        public PostRepository postRepository(){
            return new PostJpaRepository(memberRepository());
        }

        @Bean
        public MemberRepository memberRepository(){
            HikariDataSource dataSource = new HikariDataSource();
            dataSource.setJdbcUrl("jdbc:h2:tcp://localhost/~/jpa");
            dataSource.setUsername("sa");
            dataSource.setPassword("");
            return new MemberJdbcRepository(dataSource, new JdbcTemplate(dataSource));
        }

        @Bean
        public NotificationService notificationService(){
            return new NotificationServiceImpl();
        }
    }

    @DisplayName("1. 유저가 게시글을 생성하면 생성되어야 한다.")
    @Test
    void test_1(){
        // given
        MemberSaveDto saveMemberDto = new MemberSaveDto("Member A");
        Long savedMemberId = memberRepository.save(saveMemberDto);
        PostSaveDto saveDto = new PostSaveDto(savedMemberId, "Hello World");
        Long saveId = postService.createPost(saveDto);

        // when
        Post oldPost = postRepository.findById(saveId);

        // then
        Assertions.assertEquals("Hello World", oldPost.getName());
    }

    @DisplayName("2. 유저가 게시글에 좋아요를 누르면 좋아요 수가 1 증가해야 한다.")
    @Test
    void test_2(){
        // given
        MemberSaveDto saveMemberDto = new MemberSaveDto("Member A");
        Long savedMemberId = memberRepository.save(saveMemberDto);
        PostSaveDto saveDto = new PostSaveDto(savedMemberId, "Hello World");
        Long saveId = postService.createPost(saveDto);
        Post oldPost = postRepository.findById(saveId);
        int oldLikeCount = oldPost.getLikeCount();

        // when
        PostUpdateDto updateDto = new PostUpdateDto(saveId, oldPost.getName(), oldPost.getLikeCount() + 1);
        postService.sendLike(updateDto);

        // then
        Post newPost = postRepository.findById(saveId);
        Assertions.assertEquals(oldLikeCount + 1, newPost.getLikeCount());
    }
}