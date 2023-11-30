package com.joonfluence.starbucks.domain.user.order.repository;

import com.joonfluence.starbucks.domain.user.order.dto.OrderSaveDto;
import com.joonfluence.starbucks.domain.user.order.dto.OrderUpdateDto;
import com.joonfluence.starbucks.domain.user.order.entity.Order;

import java.util.List;

public interface OrderRepository {
    Long save(OrderSaveDto dto);

    Order findById(Long orderId);

    List<Order> findAll();

    void update(OrderUpdateDto dto);

    void delete(Order order);
}
