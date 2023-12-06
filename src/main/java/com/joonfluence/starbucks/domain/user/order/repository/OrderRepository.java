package com.joonfluence.starbucks.domain.user.order.repository;

import com.joonfluence.starbucks.domain.user.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {}
