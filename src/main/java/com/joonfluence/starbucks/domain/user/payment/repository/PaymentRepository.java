package com.joonfluence.starbucks.domain.user.payment.repository;

import com.joonfluence.starbucks.domain.user.payment.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}