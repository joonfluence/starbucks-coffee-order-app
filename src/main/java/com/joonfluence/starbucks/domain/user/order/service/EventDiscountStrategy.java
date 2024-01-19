package com.joonfluence.starbucks.domain.user.order.service;

import com.joonfluence.starbucks.domain.user.order.Money;
import com.joonfluence.starbucks.domain.user.order.dto.request.OrderRequestDto;

public class EventDiscountStrategy implements DiscountStrategy {
    @Override
    public Money calculateDiscountedAmount(OrderRequestDto orderRequestDto) {

        return null;
    }
}
