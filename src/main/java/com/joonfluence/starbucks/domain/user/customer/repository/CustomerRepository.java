package com.joonfluence.starbucks.domain.user.customer.repository;

import com.joonfluence.starbucks.domain.user.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByEmail(String email);
    Boolean existsByEmail(String email);
}
