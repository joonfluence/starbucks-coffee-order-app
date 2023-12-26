package com.joonfluence.starbucks.domain.user.order.service;

import com.joonfluence.starbucks.domain.user.order.dto.request.OrderRequestDto;
import com.joonfluence.starbucks.domain.user.payment.dto.request.PaymentRequestDto;
import com.joonfluence.starbucks.domain.user.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderPaymentService {
    @Autowired
    private final OrderService orderService;

    @Autowired
    private final PaymentService paymentService;

    @Transactional
    public void processOrderAndPayment(OrderRequestDto orderRequestDto, PaymentRequestDto paymentRequestDto) {
        orderService.createOrder(orderRequestDto);
        paymentService.processPayment(paymentRequestDto);
    }
}

