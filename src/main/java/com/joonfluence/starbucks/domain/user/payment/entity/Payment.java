package com.joonfluence.starbucks.domain.user.payment.entity;

import com.joonfluence.starbucks.domain.model.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Entity
public class Payment extends BaseTimeEntity {
    @Id
    @GeneratedValue
    @Column(name = "payment_id")
    private Long id;

    private int paymentPrice;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
}
