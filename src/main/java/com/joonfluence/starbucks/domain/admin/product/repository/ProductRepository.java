package com.joonfluence.starbucks.domain.admin.product.repository;

import com.joonfluence.starbucks.domain.admin.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}