package com.joonfluence.starbucks.domain.user.order.repository;

import com.joonfluence.starbucks.domain.user.order.entity.Order;
<<<<<<< HEAD
import org.springframework.data.jpa.repository.JpaRepository;

=======
import com.joonfluence.starbucks.domain.user.payment.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

>>>>>>> 806e707 ([FEAT] Jwt Util 함수 구현 및 JwtAuthenticationFilter 적용)
public interface OrderRepository extends JpaRepository<Order, Long> {}
