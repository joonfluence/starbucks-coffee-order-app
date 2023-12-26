package com.joonfluence.starbucks.domain.user.payment.dto.request;

import com.joonfluence.starbucks.domain.user.order.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentRequestDto {
    private Long customerId;
    private Long productId;
    private Long couponId;

    public Order toEntity(PaymentRequestDto dto){
        return Order.builder().build();
    }
}
