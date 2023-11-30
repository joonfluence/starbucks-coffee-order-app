package com.joonfluence.starbucks.domain.order.service;

import com.joonfluence.starbucks.domain.order.dto.post.OrderSaveDto;
import com.joonfluence.starbucks.domain.order.dto.post.OrderUpdateDto;

public interface OrderService {
    Long createOrder(OrderSaveDto dto);
    void sendLike(OrderUpdateDto dto);
}
