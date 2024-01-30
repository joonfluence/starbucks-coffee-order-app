package com.joonfluence.starbucks.domain.user.coupon.entity;

import com.joonfluence.starbucks.domain.user.customer.entity.Customer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private BigDecimal discountAmount;
    private BigDecimal discountPercent;
    private Boolean forFree;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Customer customer;

    public void addMember(Customer customer) {
        this.customer = customer;
    }

    public void update(Coupon coupon){
        this.name = coupon.getName();
    }

    public BigDecimal calculateDiscountAmount() {
        return discountAmount;
    }
}
