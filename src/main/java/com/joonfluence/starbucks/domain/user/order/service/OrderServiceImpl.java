package com.joonfluence.starbucks.domain.user.order.service;

import com.joonfluence.starbucks.domain.user.order.dto.OrderSaveDto;
import com.joonfluence.starbucks.domain.user.order.dto.OrderUpdateDto;
import com.joonfluence.starbucks.domain.user.order.entity.Order;
import com.joonfluence.starbucks.domain.user.order.repository.OrderRepository;
import com.joonfluence.starbucks.domain.user.customer.service.NotificationService;
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
        notificationService.NotifyUser(order.getCustomer().getId());
    }
}
