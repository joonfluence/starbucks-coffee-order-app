package com.joonfluence.starbucks.domain.admin.seller.repository.jpa;

import com.joonfluence.starbucks.domain.admin.seller.entity.Seller;
import com.joonfluence.starbucks.domain.admin.seller.dto.SellerSaveDto;
import com.joonfluence.starbucks.domain.admin.seller.dto.SellerUpdateDto;
import com.joonfluence.starbucks.domain.admin.seller.repository.SellerRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class SellerJpaRepository implements SellerRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public Long save(SellerSaveDto dto) {
        Seller seller = Seller.builder().name(dto.getName()).build();
        em.persist(seller);
        return seller.getId();
    }

    @Override
    public Seller findById(Long memberId) {
        return em.find(Seller.class, memberId);
    }

    @Override
    public List<Seller> findAll() {
        return em.createQuery("select m from Member m", Seller.class).getResultList();
    }

    @Override
    public void update(SellerUpdateDto dto) {
        Seller seller = Seller.builder().id(dto.getId()).name(dto.getName()).build();
        seller.update(seller);
    }

    @Override
    public void delete(Seller seller) {
        em.remove(seller);
    }
}