package com.joonfluence.starbucks.domain.user.order.repository;

import com.joonfluence.starbucks.domain.user.order.dto.OrderSaveDto;
import com.joonfluence.starbucks.domain.user.order.dto.OrderUpdateDto;
import com.joonfluence.starbucks.domain.user.order.entity.Order;
import com.joonfluence.starbucks.domain.user.payment.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {}
