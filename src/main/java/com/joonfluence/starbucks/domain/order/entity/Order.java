package com.joonfluence.starbucks.domain.order.entity;

import com.joonfluence.starbucks.domain.user.entity.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "orders")
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private int likeCount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    public void addMember(Member member) {
        this.member = member;
    }

    public void update(Order order){
        this.name = order.getName();
        this.likeCount = order.getLikeCount();
    }
}
