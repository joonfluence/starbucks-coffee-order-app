package com.joonfluence.starbucks.domain.admin.product.repository;

import com.joonfluence.starbucks.domain.admin.product.entity.ProductPrice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductPriceRepository extends JpaRepository<ProductPrice, Long> {
}