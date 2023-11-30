package com.joonfluence.starbucks.domain.order.service;

import com.joonfluence.starbucks.domain.order.dto.post.OrderSaveDto;
import com.joonfluence.starbucks.domain.order.dto.post.OrderUpdateDto;
import com.joonfluence.starbucks.domain.order.entity.Order;
import com.joonfluence.starbucks.domain.order.repository.OrderRepository;
import com.joonfluence.starbucks.domain.user.service.NotificationService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final NotificationService notificationService;

    @Override
    public Long createOrder(OrderSaveDto dto) {
        return orderRepository.save(dto);
    }

    @Override
    public void sendLike(OrderUpdateDto dto) {
        orderRepository.update(dto);
        Order order = orderRepository.findById(dto.getId());
        notificationService.NotifyUser(order.getMember().getId());
    }
}
