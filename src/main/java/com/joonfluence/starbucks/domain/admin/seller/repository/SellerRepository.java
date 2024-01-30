package com.joonfluence.starbucks.domain.admin.seller.repository;

import com.joonfluence.starbucks.domain.admin.seller.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SellerRepository extends JpaRepository<Seller, Long> {}
