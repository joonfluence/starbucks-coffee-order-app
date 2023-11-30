package com.joonfluence.starbucks.domain.admin.shop.repository.jpa;

import com.joonfluence.starbucks.domain.admin.shop.dto.ShopSaveDto;
import com.joonfluence.starbucks.domain.admin.shop.dto.ShopUpdateDto;
import com.joonfluence.starbucks.domain.admin.shop.entity.Shop;
import com.joonfluence.starbucks.domain.admin.shop.repository.ShopRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class ShopJpaRepository implements ShopRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public Long save(ShopSaveDto dto) {
        Shop shop = Shop.builder().name(dto.getName()).build();
        em.persist(shop);
        return shop.getId();
    }

    @Override
    public Shop findById(Long memberId) {
        return em.find(Shop.class, memberId);
    }

    @Override
    public List<Shop> findAll() {
        return em.createQuery("select m from Shop m", Shop.class).getResultList();
    }

    @Override
    public void update(ShopUpdateDto dto) {
        Shop shop = Shop.builder().id(dto.getId()).name(dto.getName()).build();
        shop.update(shop);
    }

    @Override
    public void delete(Shop shop) {
        em.remove(shop);
    }
}