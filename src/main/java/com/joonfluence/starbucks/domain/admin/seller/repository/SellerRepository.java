package com.joonfluence.starbucks.domain.admin.seller.repository;

import com.joonfluence.starbucks.domain.admin.seller.entity.Seller;
import com.joonfluence.starbucks.domain.admin.seller.dto.SellerSaveDto;
import com.joonfluence.starbucks.domain.admin.seller.dto.SellerUpdateDto;

import java.util.List;

public interface SellerRepository {
    Long save(SellerSaveDto member);

    Seller findById(Long memberId);

    List<Seller> findAll();

    void update(SellerUpdateDto dto);

    void delete(Seller seller);
}
