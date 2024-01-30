package com.joonfluence.starbucks.domain.user.order.entity;

import com.joonfluence.starbucks.domain.model.BaseTimeEntity;
import com.joonfluence.starbucks.domain.user.customer.entity.Customer;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "orders")
@Entity
public class Order extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", nullable = false)
    private Long id;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @Enumerated(EnumType.STRING)
    private OrderType orderType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Customer customer;

    public void addMember(Customer customer) {
        this.customer = customer;
    }

    public void updateCustomer(Customer customer) {
        this.customer = customer;
    }
}
