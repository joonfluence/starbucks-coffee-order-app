package com.joonfluence.starbucks.domain.user.order.service;

import com.joonfluence.starbucks.domain.user.order.Money;
import com.joonfluence.starbucks.domain.user.order.dto.request.OrderRequestDto;

public interface DiscountStrategy {
    Money calculateDiscountedAmount(OrderRequestDto orderRequestDto);
}
