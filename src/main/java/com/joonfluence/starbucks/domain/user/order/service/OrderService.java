package com.joonfluence.starbucks.domain.user.order.service;

import com.joonfluence.starbucks.domain.user.order.dto.OrderSaveDto;
import com.joonfluence.starbucks.domain.user.order.dto.OrderUpdateDto;

public interface OrderService {
    Long createOrder(OrderSaveDto dto);
    void sendLike(OrderUpdateDto dto);
}
