package com.joonfluence.starbucks.domain.user.payment.dto.request;

import com.joonfluence.starbucks.domain.user.order.entity.Order;
import com.joonfluence.starbucks.domain.user.payment.entity.Payment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentRequestDto {
    private Long orderId;
    private int paymentPrice;
    private BigDecimal discountedPrice;
    private PaymentStatus paymentStatus;

    public Payment toEntity(PaymentRequestDto dto){
        return Payment.builder().build();
    }
}
