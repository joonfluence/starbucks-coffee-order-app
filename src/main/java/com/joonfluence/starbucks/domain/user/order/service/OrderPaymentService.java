package com.joonfluence.starbucks.domain.user.order.service;

import com.joonfluence.starbucks.domain.user.customer.entity.Customer;
import com.joonfluence.starbucks.domain.user.customer.repository.CustomerRepository;
import com.joonfluence.starbucks.domain.user.order.Money;
import com.joonfluence.starbucks.domain.user.order.dto.request.OrderRequestDto;
import com.joonfluence.starbucks.domain.user.payment.dto.request.PaymentRequestDto;
import com.joonfluence.starbucks.domain.user.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderPaymentService {
    private final CustomerRepository customerRepository;
    private final OrderService orderService;
    private final PaymentService paymentService;
    private final DiscountStrategyFactory discountStrategyFactory;

    @Transactional
    public void processOrderAndPayment(OrderRequestDto orderRequestDto) {
        orderService.createOrder(orderRequestDto);
        Customer customer = customerRepository.findById(orderRequestDto.getCustomerId()).get();
        PaymentRequestDto paymentRequestDto = PaymentRequestDto.builder().build();
        DiscountStrategy discountStrategy = discountStrategyFactory.getDiscountStrategy(orderRequestDto.getDiscountType());
        Money discountedAmount = discountStrategy.calculateDiscountedAmount(orderRequestDto);
        paymentRequestDto.setDiscountedPrice(discountedAmount.getAmount());
        paymentService.processPayment(paymentRequestDto);
    }
}