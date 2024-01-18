package com.joonfluence.starbucks.domain.user.order.dto.request;

import java.util.List;
import com.joonfluence.starbucks.domain.user.order.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderRequestDto {
    private Long customerId;
    private List<Long> productIds;
    private Long couponId;

    public Order toEntity(OrderRequestDto dto){
        return Order.builder().build();

    }
}