package com.joonfluence.starbucks.domain.user.payment.service;

import com.joonfluence.starbucks.domain.user.payment.dto.request.PaymentRequestDto;
import com.joonfluence.starbucks.domain.user.payment.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository repository;

    @Transactional
    public void payOrder() {
        System.out.println("실제 결제하고 주문하는 과정을 처리한다");
    }

    // TODO : 추가로 로직 작성 필요
    public void processPayment(PaymentRequestDto paymentRequestDto) {
        System.out.println("PaymentService.processPayment");
    }
}
