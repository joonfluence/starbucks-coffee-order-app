package com.joonfluence.starbucks.domain.admin.shop.repository;

import com.joonfluence.starbucks.domain.admin.shop.dto.ShopSaveDto;
import com.joonfluence.starbucks.domain.admin.shop.dto.ShopUpdateDto;
import com.joonfluence.starbucks.domain.admin.shop.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShopRepository extends JpaRepository<Shop, Long> {}
