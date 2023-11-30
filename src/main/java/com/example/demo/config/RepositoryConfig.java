package com.example.demo.config;

import com.example.demo.repository.jpa.MemberJpaRepository;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.jpa.PostJpaRepository;
import com.example.demo.repository.PostRepository;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfig {
    // @Bean
    public PostRepository postRepository(){
        return new PostJpaRepository(memberRepository());
    }

    // @Bean
    public MemberRepository memberRepository(){
        return new MemberJpaRepository();
    }
}
