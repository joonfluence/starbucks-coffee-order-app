package com.joonfluence.starbucks.domain.user.order.service;


import com.joonfluence.starbucks.domain.admin.product.exception.NoSuchProductException;
import com.joonfluence.starbucks.domain.admin.product.repository.ProductRepository;
import com.joonfluence.starbucks.domain.user.customer.exception.NoSuchCustomerException;
import com.joonfluence.starbucks.domain.user.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceValidator {
    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;

    public void validateCustomer(Long customerId) {
        customerRepository.findById(customerId).orElseThrow(() -> new NoSuchCustomerException("해당 유저는 존재하지 않습니다."));
    }

    public void validateProducts(List<Long> productIds) {
        productIds.forEach(productId -> {
            productRepository.findById(productId).orElseThrow(() -> {
                String errMsg = productId + "번 상품이 존재하지 않습니다.";
                throw new NoSuchProductException(errMsg);
            });
        });
    }
}
