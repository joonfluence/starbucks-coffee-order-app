package com.joonfluence.starbucks.domain.user.order.service;

import com.joonfluence.starbucks.domain.admin.product.entity.Product;
import com.joonfluence.starbucks.domain.admin.product.exception.NoSuchProductException;
import com.joonfluence.starbucks.domain.admin.product.repository.ProductRepository;
import com.joonfluence.starbucks.domain.user.customer.exception.NoSuchCustomerException;
import com.joonfluence.starbucks.domain.user.customer.repository.CustomerRepository;
import com.joonfluence.starbucks.domain.user.order.entity.OrderItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceValidator {
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    public void validateCustomer(Long customerId) {
        customerRepository.findById(customerId).orElseThrow(() -> {
            throw new NoSuchCustomerException("해당 유저가 존재하지 않습니다");
        });
    }

    public void validateProducts(List<Long> productIds){
        productIds.forEach(p -> {
            productRepository.findById(p).orElseThrow(() -> {
                throw new NoSuchProductException("해당 상품이 존재하지 않습니다");
            });
        });
    }
}
