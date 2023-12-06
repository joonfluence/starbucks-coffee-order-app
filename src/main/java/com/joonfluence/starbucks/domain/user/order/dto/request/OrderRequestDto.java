package com.joonfluence.starbucks.domain.user.order.dto.request;

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
    private Long productId;
    private String name;

    public Order toEntity(OrderRequestDto dto){
        return Order.builder().name(dto.getName()).build();
    }
}
