package com.joonfluence.starbucks.domain.user.order.dto.request;

import com.joonfluence.starbucks.domain.user.order.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderRequestDto {
    private Long customerId;
    private List<Long> productIds;
    private List<CouponProduct> couponProductList;
    private Integer orderPrice;
    private Integer usedMileageAmount;
    private Boolean isCompanyDiscount;
    private DiscountType discountType;

    public Order toEntity(OrderRequestDto dto){
        return Order.builder().build();
    }
}
