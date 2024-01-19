package com.joonfluence.starbucks.domain.user.customer.service;

import com.joonfluence.starbucks.domain.user.customer.entity.Customer;
import com.joonfluence.starbucks.domain.user.customer.exception.NoSuchCustomerException;
import com.joonfluence.starbucks.domain.user.customer.repository.CustomerRepository;
import com.joonfluence.starbucks.domain.user.order.dto.request.OrderRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public void join() {
        System.out.println("MemberServiceImpl.join");
    }

    public Customer getCustomer(Long customerId) {
        return customerRepository.findById(customerId).orElseThrow(() -> new NoSuchCustomerException("해당 유저는 존재하지 않습니다."));
    }
}
