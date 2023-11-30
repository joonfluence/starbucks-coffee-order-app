package com.joonfluence.starbucks.domain.user.entity;

import com.joonfluence.starbucks.domain.delivery.entity.Delivery;
import com.joonfluence.starbucks.domain.order.entity.Order;
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

    /*
    @OneToMany(mappedBy = "member")
    private List<Order> orderList = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Delivery> deliveryList = new ArrayList<>();

    public void addOrder(Order order){
        order.addMember(this);
        this.orderList.add(order);
    }

    public void addDelivery(Delivery delivery){
        delivery.addMember(this);
        this.deliveryList.add(delivery);
    }
    */

    public void update(Member member){
        this.name = member.getName();
    }
}
