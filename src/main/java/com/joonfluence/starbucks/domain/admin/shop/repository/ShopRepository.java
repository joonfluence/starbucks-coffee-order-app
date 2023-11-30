package com.joonfluence.starbucks.domain.admin.shop.repository;

import com.joonfluence.starbucks.domain.admin.shop.dto.ShopSaveDto;
import com.joonfluence.starbucks.domain.admin.shop.dto.ShopUpdateDto;
import com.joonfluence.starbucks.domain.admin.shop.entity.Shop;

import java.util.List;

public interface ShopRepository {
    Long save(ShopSaveDto member);

    Shop findById(Long memberId);

    List<Shop> findAll();

    void update(ShopUpdateDto dto);

    void delete(Shop shop);
}
