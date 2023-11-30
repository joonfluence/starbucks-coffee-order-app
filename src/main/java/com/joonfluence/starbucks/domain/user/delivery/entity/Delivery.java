package com.joonfluence.starbucks.domain.user.delivery.entity;

import com.joonfluence.starbucks.domain.user.customer.entity.Customer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private int likeCount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Customer customer;

    public void addMember(Customer customer) {
        this.customer = customer;
    }

    public void update(Delivery delivery){
        this.name = delivery.getName();
        this.likeCount = delivery.getLikeCount();
    }
}
