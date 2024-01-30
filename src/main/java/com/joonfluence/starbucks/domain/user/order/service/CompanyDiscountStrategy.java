package com.joonfluence.starbucks.domain.user.order.service;

import com.joonfluence.starbucks.domain.user.order.Money;
import com.joonfluence.starbucks.domain.user.order.dto.request.OrderRequestDto;

public class CompanyDiscountStrategy implements DiscountStrategy {
    @Override
    public Money calculateDiscountedAmount(OrderRequestDto orderRequestDto) {
        Integer orderPrice = orderRequestDto.getOrderPrice();
        return Money.wons(orderPrice).times(0.7);
    }
}
