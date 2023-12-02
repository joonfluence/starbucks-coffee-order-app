package com.joonfluence.starbucks.domain.user.customer.repository;

import com.joonfluence.starbucks.domain.user.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {}
