package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "member")
    private List<Post> postList = new ArrayList<>();

    public void addPost(Post post){
        post.addMember(this);
        this.postList.add(post);
    }

    public void update(Member member){
        this.name = member.getName();
    }
}
