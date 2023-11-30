package com.joonfluence.starbucks.domain.order.repository;

import com.joonfluence.starbucks.domain.order.dto.post.OrderSaveDto;
import com.joonfluence.starbucks.domain.order.dto.post.OrderUpdateDto;
import com.joonfluence.starbucks.domain.order.entity.Order;

import java.util.List;

public interface OrderRepository {
    Long save(OrderSaveDto dto);

    Order findById(Long orderId);

    List<Order> findAll();

    void update(OrderUpdateDto dto);

    void delete(Order order);
}
