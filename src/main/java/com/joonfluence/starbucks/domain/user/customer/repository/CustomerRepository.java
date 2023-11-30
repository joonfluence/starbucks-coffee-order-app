package com.joonfluence.starbucks.domain.user.customer.repository;

import com.joonfluence.starbucks.domain.user.customer.dto.CustomerSaveDto;
import com.joonfluence.starbucks.domain.user.customer.dto.CustomerUpdateDto;
import com.joonfluence.starbucks.domain.user.customer.entity.Customer;

import java.util.List;

public interface CustomerRepository {
    Long save(CustomerSaveDto dto);

    Customer findById(Long memberId);

    List<Customer> findAll();

    void update(CustomerUpdateDto dto);

    void delete(Customer customer);
}
